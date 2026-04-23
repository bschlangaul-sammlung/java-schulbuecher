package schulbuecher.tools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Kommandozeilenwerkzeug zum rekursiven Erzeugen fehlender
 * package-info.java-Dateien.
 */
public final class PackageInfoGenerator
{
    private PackageInfoGenerator()
    {
    }

    /**
     * Aufruf: java schulbuecher.tools.PackageInfoGenerator &lt;paketPfad&gt;
     * [&lt;sourceRoot&gt;]
     */
    public static void main(String[] args)
    {
        if (args.length < 1 || args.length > 2)
        {
            printUsage();
            System.exit(1);
        }

        Path packagePath = Paths.get(args[0]).toAbsolutePath().normalize();
        Path sourceRoot = args.length == 2
                ? Paths.get(args[1]).toAbsolutePath().normalize()
                : detectSourceRoot(packagePath);

        if (!Files.isDirectory(packagePath))
        {
            System.err.println(
                "Fehler: Paketpfad ist kein Verzeichnis: " + packagePath);
            System.exit(2);
        }

        if (sourceRoot == null || !Files.isDirectory(sourceRoot))
        {
            System.err.println(
                "Fehler: Quellwurzel konnte nicht ermittelt werden. Bitte als 2. Parameter angeben.");
            System.exit(3);
        }

        if (!packagePath.startsWith(sourceRoot))
        {
            System.err.println(
                "Fehler: Paketpfad liegt nicht unterhalb der Quellwurzel.");
            System.err.println("Paketpfad: " + packagePath);
            System.err.println("Quellwurzel: " + sourceRoot);
            System.exit(4);
        }

        try
        {
            int created = ensurePackageInfos(packagePath, sourceRoot);
            System.out.println("Fertig. Neu erstellt: " + created
                    + " package-info.java-Datei(en).");
        }
        catch (IOException exception)
        {
            System.err
                .println("Fehler beim Verarbeiten: " + exception.getMessage());
            System.exit(5);
        }
    }

    private static int ensurePackageInfos(Path packagePath, Path sourceRoot)
            throws IOException
    {
        int createdCount = 0;

        try (Stream<Path> paths = Files.walk(packagePath))
        {
            Path[] directories = paths.filter(Files::isDirectory)
                .sorted(Comparator.naturalOrder())
                .toArray(Path[]::new);

            for (Path directory : directories)
            {
                Path packageInfo = directory.resolve("package-info.java");
                boolean shouldCreate = isRelevantPackageDirectory(directory)
                        && !Files.exists(packageInfo);

                if (shouldCreate)
                {
                    String packageName = toPackageName(directory, sourceRoot);
                    String content = buildPackageInfoContent(packageName);
                    Files.writeString(packageInfo,
                        content,
                        StandardCharsets.UTF_8);

                    createdCount++;
                    System.out.println("Erstellt: " + packageInfo);
                }
            }
        }

        return createdCount;
    }

    private static boolean isRelevantPackageDirectory(Path directory)
            throws IOException
    {
        try (Stream<Path> children = Files.list(directory))
        {
            return children.anyMatch(path -> {
                String fileName = path.getFileName().toString();
                if (Files.isDirectory(path))
                {
                    return true;
                }
                return fileName.endsWith(".java")
                        && !"package-info.java".equals(fileName);
            });
        }
    }

    private static String toPackageName(Path packageDirectory, Path sourceRoot)
    {
        Path relativePath = sourceRoot.relativize(packageDirectory);
        String normalized = relativePath.toString()
            .replace('/', '.')
            .replace('\\', '.');
        if (normalized.isBlank())
        {
            throw new IllegalArgumentException(
                    "Die Quellwurzel selbst ist kein gueltiges Paket.");
        }
        return normalized;
    }

    private static String buildPackageInfoContent(String packageName)
    {
        return "/**\n" + " * Paketdokumentation.\n" + " */\n" + "package "
                + packageName + ";\n";
    }

    private static Path detectSourceRoot(Path packagePath)
    {
        Path current = packagePath;
        while (current != null)
        {
            Path candidate = current.resolve("src")
                .resolve("main")
                .resolve("java");
            if (Files.isDirectory(candidate)
                    && packagePath.startsWith(candidate))
            {
                return candidate;
            }
            current = current.getParent();
        }
        return null;
    }

    private static void printUsage()
    {
        System.out.println("Verwendung:");
        System.out.println(
            "  java schulbuecher.tools.PackageInfoGenerator <paketPfad> [<sourceRoot>]");
        System.out.println("Beispiel:");
        System.out.println(
            "  java schulbuecher.tools.PackageInfoGenerator src/main/java/schulbuecher");
    }
}
