package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_03.qr_code;

import java.util.Arrays;
import java.util.List;
import greenfoot.*;

/**
 * MyWorld enthält alle Schritte um einen QR-Code der verschiedenen Versionen zu
 * erstellen. Dabei wird der String in der Textbox zur Erstellung verwendet.
 * Alternativ können die Pixel des QR-Codes mit der Maus "eingegeben" werden und
 * anschließend als Bitfolge gelesen und mit Fehlercode ergänzt werden. Der
 * Ergebnis-QR-Code kann mit jeder Smartphone-APP gescannt werden.
 * <p>
 * Nicht implementiert: verschiedene Qualitäten der Fehlerkorrektur (nur LOW
 * ECC)
 * <p>
 * Pixel einlesen erlaubt es selbst Pixel in den QR-Code einzutragen, um
 * anschließend eine Fehlerkorrektur berechnen zu lassen. Der so entstehende
 * QR-Code ist dann mit einer APP lesbar.
 *
 * @author Hilmar Vogel - vogel@akg-schwabach.de
 *
 * @version 1.2 - 13.01.2024 The MIT License (MIT) Copyright © 2023 H. Vogel
 *     Permission is hereby granted, free of charge, to any person obtaining a
 *     copy of this software and associated documentation files (the
 *     “Software”), to deal in the Software without restriction, including
 *     without limitation the rights to use, copy, modify, merge, publish,
 *     distribute, sublicense, and/or sell copies of the Software, and to permit
 *     persons to whom the Software is furnished to do so, subject to the
 *     following conditions: The above copyright notice and this permission
 *     notice shall be included in all copies or substantial portions of the
 *     Software. THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
 *     EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *     MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 *     NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *     DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 *     OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
 *     USE OR OTHER DEALINGS IN THE SOFTWARE. unter Verwendung der
 *     QR-Code-Implementierung von https://github.com/nayuki/QR-Code-generator
 */
public class MyWorld extends World
{
    int size = 21;

    int pixelsize = 20;

    int marked = 0;

    int maxBitlength = 0;

    int maske = 1;

    int zustandA3a = 0;

    boolean debug = false;

    boolean istMaskeAn = false;

    int maxButtons = 14;

    int version = 1;

    int ystep = 36;

    Button[] buttons = new Button[maxButtons];

    Button plus, minus, reihenfolge, versionsplus, versionsminus, masknrplus,
            masknrminus;

    Pixel[][] matrix;

    PixelMarker marker;

    int[][] pattern;

    int patternCounter = -1; // PixelMarker notshowing

    boolean[][] isFunction;

    QrCode.Ecc errorCorrectionLevel = QrCode.Ecc.LOW;

    TextField tf, tfversion, tfmaskenr;

    Blockmarker blockmarker;

    Output outputBox;

    BitBuffer bbMain;

    public MyWorld()
    {
        super(680, 720, 1);
        matrix = new Pixel[177][177];
        isFunction = new boolean[177][177];
        pattern = new int[200000][2];
        prepare();
    }

    private void prepare()
    {
        clearAll();
        // Bild für Aufgabe S70A3a
        blockmarker = new Blockmarker();
        addObject(blockmarker, 240, 650);
        // QR-Code Versionsbuttons
        versionsplus = new Button("btplus", maxButtons + 3, this);
        versionsminus = new Button("btminus", maxButtons + 4, this);
        masknrplus = new Button("btplus", maxButtons + 5, this);
        masknrminus = new Button("btminus", maxButtons + 6, this);
        tfversion = new TextField(120, 38, false, false, Color.WHITE,
                Color.BLACK, "Version 1");
        tfmaskenr = new TextField(120, 38, false, false, Color.WHITE,
                Color.BLACK, "Maske #" + maske);
        addObject(versionsplus, 480, 15);
        addObject(versionsminus, 520, 15);
        addObject(tfversion, 605, 15);
        addObject(masknrplus, 480, 19 + ystep * 13);
        addObject(masknrminus, 520, 19 + ystep * 13);
        addObject(tfmaskenr, 605, 19 + ystep * 13);
        // Buttons
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new Button("bt" + i, i, this);
            if (buttons[i] != null)
                addObject(buttons[i], 560,
                        55 + i * ystep + (i > 11 ? ystep : 0));
        }
        plus = new Button("btplus", maxButtons, this, true);
        minus = new Button("btminus", maxButtons + 1, this, true);
        reihenfolge = new Button("btreihenfolge", maxButtons + 2, this);
        buttons[11].activedChange();
        outputBox = new Output("Ausgabe");
        tf = new TextField(400, 30, false, true, Color.YELLOW, Color.BLACK,
                "Info11");
        addObject(reihenfolge, 120, 445);
        addObject(plus, 25, 445);
        addObject(minus, 210, 445);
        addObject(tf, 200, 500);
        addObject(outputBox, 450, 660);
        Greenfoot.start();
    }

    public void actionButton(int nr)
    {
        switch (nr)
        {
        // Hilfe für Bit-Muster
        case 0:
            printString(
                    "Mit Hilfe der fünf folgenden Befehle wird die Grundstruktur des QR-Codes erstellt",
                    false);
            break;

        // Knopf Synchronisation
        case 1:
            drawTimingpattern();
            break;

        // Knopf Positionierung
        case 2:
            drawPositionpattern();
            break;

        // Knopf Formatbits
        case 3:
            drawFormatBits();
            break;

        // Knopf Ausrichtung
        case 4:
            drawAligmentpattern();
            break;

        // Knopf Versionbits
        case 5:
            drawVersion();
            break;

        // Hilfe für Daten
        case 6:
            printString(
                    "Die Daten können aus dem gelben Eingabefeld erstellt oder\naus dem QR-Code mit 'Pixel einlesen' eingelesen werden.\nHinweis: Das Einlesen von Pixeln ist nur für sehr kurze Text sinnvoll, da man für jeden\nBuchstaben acht Pixel setzen muss.\nIm Anschluss kann der Code mit Füllzeichen ergänzt werden, falls er nicht den Gesamtendatenbereich des QR-Codes benötigt.",
                    false);
            break;

        // Knopf Eingabe codieren
        case 7:
            bbMain = stringToBinary(tf.getText(), true);
            if (bbMain != null)
                drawText(bbMain);
            if (version == 1)
                blockmarker.show();
            break;

        // Knopf Code auffüllen
        case 8:
            bbMain = fillToByteLength(bbMain);
            bbMain = fillUpToDataCapacity(bbMain);
            drawText(bbMain);
            break;

        // Hilfe für ECC
        case 9:
            break;

        // Knopf Fehlerkorrekturcode
        case 10:
            drawText(bbToECCBytes(bbMain));
            break;

        // Knopf Maske an/aus
        case 11:
            setMask(maske);
            istMaskeAn = !istMaskeAn;
            break;

        // Knopf Zurücksetzen
        case 12:
            clearAll();
            break;

        // Knopf Pixel einlesen
        case 13:
            bbMain = readDataFromQRCode();
            break;

        // Knopf Reihenfolge +
        case 14:
            showEntryorder(1);
            break;

        // Knopf Reihenfolge -
        case 15:
            showEntryorder(-1);
            break;

        // Hilfe zu Reihenfolge
        case 16:
            outputBox.setText("+/- um Eintragungsreihenfolge anzuzeigen!");
            break;

        // Knopf Version +
        case 17:
            if (version < 40)
                version++;
            tfversion.setText("Version " + version);
            tfversion.setActiveTextField();
            size = 4 * version + 17;
            clearAll();
            break;

        // Knopf Version -
        case 18:
            if (version > 1)
                version--;
            tfversion.setText("Version " + version);
            tfversion.setActiveTextField();
            size = 4 * version + 17;
            clearAll();
            break;

        // Knopf Maske +
        case 19:
            if (maske < 7 && !istMaskeAn)
                maske++;
            tfmaskenr.setText("Maske #" + maske);
            tfmaskenr.setActiveTextField();
            break;

        // Knopf Maske -
        case 20:
            if (maske > 0 && !istMaskeAn)
                maske--;
            tfmaskenr.setText("Maske #" + maske);
            tfmaskenr.setActiveTextField();
            break;
        }
    }

    /**
     * Resets QR-Code-Matrix
     */
    private void clearAll()
    {
        pixelsize = 420 / (version * 4 + 17);
        for (int x = 0; x < 177; x++)
        {
            for (int y = 0; y < 177; y++)
            {
                if (matrix[x][y] != null)
                    removeObject(matrix[x][y]);
            }
        }
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                matrix[x][y] = new Pixel(-1, true, this, pixelsize); // white,
                                                                     // clickable
                isFunction[x][y] = false;
                addObject(matrix[x][y], x * pixelsize + pixelsize / 2,
                        y * pixelsize + pixelsize / 2);
            }
        }
        if (marker != null)
            removeObject(marker);
        marker = new PixelMarker(this, pixelsize);
        addObject(marker, size * pixelsize + pixelsize / 2,
                size * pixelsize + pixelsize / 2);
        marker.setVisible(false);
        patternCounter = -1;
        generatePattern();
        if (istMaskeAn)
        {
            buttons[11].resetButton();
            istMaskeAn = false;
        }
    }

    /**
     * Encodes a String s to Bitdata for QR-Code-Drawing
     *
     * @param modeBits adds QR-Code-Mode as bitcode and charnummers as bitcode
     */
    private BitBuffer stringToBinary(String s, boolean modeBits)
    {
        String output = "";
        output = "'" + s + "' ";
        BitBuffer bb = new BitBuffer();
        BitBuffer bb2 = new BitBuffer();
        List<QrSegment> qrseg = QrSegment.makeSegments(s);
        for (QrSegment qr : qrseg)
        {
            output += "Zeichen: " + qr.numChars + " Mode:" + qr.mode + "\n";
            if (modeBits)
            {
                bb.appendBits(qr.mode.modeBits, 4);
                output += bb.toString(true) + " ";
                bb.appendBits(qr.numChars, qr.mode.numCharCountBits(version));
                bb2.appendBits(qr.numChars, qr.mode.numCharCountBits(version));
                output += bb2.toString(true);
            }
            bb.appendData(qr.data);
            output += " " + qr.data.toString(true) + "\n";
        }
        if (debug)
            System.out.println(output);
        // Check if enough databytes in QR-Code Version
        int dataUsedBits;
        int dataCapacityBits = QrCode.getNumDataCodewords(version,
                errorCorrectionLevel) * 8; // Number of data bits available
        dataUsedBits = QrSegment.getTotalBits(qrseg, version);
        if (!(dataUsedBits != -1 && dataUsedBits <= dataCapacityBits))
        {
            printString("Eingabe ist zu groß für die QR-Code Version #"
                    + version + "\nVersion erhöhen!", false);
            return null;
        }
        else
        {
            printString(output, false);
            return bb;
        }
    }

    /**
     * Add terminator and pad up to a byte if applicable
     */
    private BitBuffer fillToByteLength(BitBuffer bb)
    {
        String output = "";
        bb.appendBits(0, Math.min(4,
                QrCode.getNumDataCodewords(version, errorCorrectionLevel) * 8
                        - bb.bitLength()));
        bb.appendBits(0, (8 - bb.bitLength() % 8) % 8);
        assert bb.bitLength() % 8 == 0;
        output = bb.toString(true) + " #mit 0ern füllen.";
        printString(output, true);
        return bb;
    }

    /**
     * Pad with alternating bytes until data capacity is reached
     */
    private BitBuffer fillUpToDataCapacity(BitBuffer bb)
    {
        String output;
        for (int padByte = 0xEC; bb.bitLength() < QrCode.getNumDataCodewords(
                version, errorCorrectionLevel) * 8; padByte ^= 0xEC ^ 0x11)
            bb.appendBits(padByte, 8);
        output = bb.toString(true) + " #bis zur maximalen Kapazität füllen.";
        printString(output, true);
        return bb;
    }

    /**
     * Pack bits into bytes in big endian and do Error Correction
     */
    private byte[] bbToECCBytes(BitBuffer bb)
    {
        byte[] dataCodewords = new byte[bb.bitLength() / 8];
        for (int i = 0; i < bb.bitLength(); i++)
            dataCodewords[i >>> 3] |= bb.getBit(i) << (7 - (i & 7));
        byte[] output = addEccAndInterleave(dataCodewords);
        if (debug)
            System.out.println("byte length " + dataCodewords.length);
        return output;
    }

    /**
     * Draw alternating black|white timingpattern
     */
    private void drawTimingpattern() // Timingpattern
    {
        for (int i = 0; i < size; i++)
        {
            setFunctionModule(6, i, (~i & 1) == 1);
            setFunctionModule(i, 6, (~i & 1) == 1);
        }
        generatePattern();
        outputBox.setText("Synchronisationsmuster gesetzt");
    }

    /**
     * Draw three positioningpattern at the three corners of the QR-Code
     */
    private void drawPositionpattern() // Finderpattern
    {
        drawFinderPattern(3, 3);
        drawFinderPattern(size - 4, 3);
        drawFinderPattern(3, size - 4);
        generatePattern();
        outputBox.setText("Positionsmuster gesetzt");
    }

    /**
     * Draw aligmentpattern depending on the versionnumber
     */
    private void drawAligmentpattern()
    {
        if (version == 1)
            outputBox.setText("Version#" + version
                    + " benötigt keine Ausrichtungsmuster.");
        else
        {
            // Ausrichtungsquadrate zeichenen
            int[] alignPatPos = getAlignmentPatternPositions();
            int numAlign = alignPatPos.length;
            for (int i = 0; i < numAlign; i++)
            {
                for (int j = 0; j < numAlign; j++)
                {
                    // Don't draw on the three finder corners
                    if (!(i == 0 && j == 0 || i == 0 && j == numAlign - 1
                            || i == numAlign - 1 && j == 0))
                        drawAlignmentPatternSubroutine(alignPatPos[i],
                                alignPatPos[j]);
                }
            }
            generatePattern();
        }
    }

    /**
     * Draw finderpattern depending on the versionnumber
     */
    private void drawFinderPattern(int x, int y)
    {
        for (int dy = -4; dy <= 4; dy++)
        {
            for (int dx = -4; dx <= 4; dx++)
            {
                int dist = Math.max(Math.abs(dx), Math.abs(dy)); // Chebyshev/infinity
                                                                 // norm
                int xx = x + dx, yy = y + dy;
                if (0 <= xx && xx < size && 0 <= yy && yy < size)
                    setFunctionModule(xx, yy, (dist != 2 && dist != 4));
            }
        }
    }

    /**
     * Show markerpixel
     */
    public void showEntryorder(int i)
    {
        patternCounter = patternCounter + i;
        if (patternCounter > maxBitlength)
        {
            patternCounter = -1;
        }
        else if (patternCounter < -1)
            patternCounter = maxBitlength;
        if (patternCounter == -1)
            marker.setVisible(false);
        else
        {
            marker.setVisible(true);
            marker.setLocation(
                    pattern[patternCounter][0] * pixelsize + pixelsize / 2,
                    pattern[patternCounter][1] * pixelsize + pixelsize / 2);
        }
    }

    public void drawText(String input)
    {
        input = input.replaceAll(" ", "");
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '0')
                setDataModule(pattern[i][0], pattern[i][1], false);
            else
                setDataModule(pattern[i][0], pattern[i][1], true);
        }
    }

    public void drawText(BitBuffer bb)
    {
        for (int i = 0; i < bb.bitLength(); i++)
        {
            if (bb.getBit(i) == 0)
                setDataModule(pattern[i][0], pattern[i][1], false);
            else
                setDataModule(pattern[i][0], pattern[i][1], true);
        }
    }

    public void drawText(byte[] input)
    {
        if (debug)
            System.out.println("DrawText bytes: " + input.length + " Max. Bits"
                    + maxBitlength);
        String output = "";
        int i = 0;
        while (i < input.length * 8)
        {
            if (getBit(input[i >>> 3], 7 - (i & 7)))
            {
                setDataModule(pattern[i][0], pattern[i][1], true);
                output += "1";
            }
            else
            {
                setDataModule(pattern[i][0], pattern[i][1], false);
                output += "0";
            }
            if ((i + 1) % 8 == 0)
                output += " ";
            i++;
        }
        // If this QR Code has any remainder bits (0 to 7), they will be filled
        // with 0/false/light
        while (i <= maxBitlength)
        {
            setDataModule(pattern[i][0], pattern[i][1], false);
            output += "0";
            i++;
        }
        printString(output, false);
    }

    /**
     * Enable/disable mask
     */
    public void setMask(int msk)
    {
        outputBox.setText("Maske #" + msk);
        applyMask(msk);
        drawFormatBits(msk);
    }

    /**
     * Enable/disable mask
     */
    private void generatePattern()
    {
        int i = 0; // patterncounter
        // Bits mit Zick-Zack-Muster zeichnen
        for (int right = size - 1; right >= 1; right -= 2)
        { // Index of right column in each column pair
            if (right == 6)
                right = 5;
            for (int vert = 0; vert < size; vert++)
            { // Vertical counter
                for (int j = 0; j < 2; j++)
                {
                    int x = right - j; // Actual x coordinate
                    boolean upward = ((right + 1) & 2) == 0;
                    int y = upward ? size - 1 - vert : vert; // Actual y
                                                             // coordinate
                    if (!isFunction[y][x])
                    {
                        pattern[i][1] = y;
                        pattern[i][0] = x;
                        // Debug
                        if (debug)
                            System.out.println(
                                    "i: " + i + " (" + x + "|" + y + ")");
                        i++;
                    }
                }
            }
        }
        maxBitlength = i - 1;
    }

    /**
     * Read pixels from QR-Code
     */
    public BitBuffer readDataFromQRCode()
    {
        int bytelength = (int) (maxBitlength - 4) / 8;
        BitBuffer bb = new BitBuffer();
        for (int i = 0; i < maxBitlength; i++)
        {
            if (matrix[pattern[i][0]][pattern[i][1]].getInfo() == 1)
                bb.appendBits(1, 1);
            else if (matrix[pattern[i][0]][pattern[i][1]].getInfo() == 0)
                bb.appendBits(0, 1);
            else
                break;
        }
        outputBox.setText("QR-Data in bits:" + bb.bitLength());
        printString(bb.toString(true), false);
        return bb;
    }

    /**
     * Draw bits for formatdata
     */
    public void drawFormatBits()
    {
        outputBox.setText("Formatmuster gesetzt");
        drawFormatBits(1);
        generatePattern();
    }

    ////////////////////////////////////////////////////////////////////////////
    // Reed-Solomon Error Correction Code
    private byte[] addEccAndInterleave(byte[] data)
    {
        // Calculate parameter numbers 428
        int numBlocks = NUM_ERROR_CORRECTION_BLOCKS[errorCorrectionLevel
                .ordinal()][version];
        int blockEccLen = ECC_CODEWORDS_PER_BLOCK[errorCorrectionLevel
                .ordinal()][version];
        int rawCodewords = getNumRawDataModules(version) / 8;
        int numShortBlocks = numBlocks - rawCodewords % numBlocks;
        int shortBlockLen = rawCodewords / numBlocks;
        // Split data into blocks and append ECC to each block
        byte[][] blocks = new byte[numBlocks][];
        byte[] rsDiv = reedSolomonComputeDivisor(blockEccLen);
        for (int i = 0, k = 0; i < numBlocks; i++)
        {
            byte[] dat = Arrays.copyOfRange(data, k, k + shortBlockLen
                    - blockEccLen + (i < numShortBlocks ? 0 : 1));
            k += dat.length;
            byte[] block = Arrays.copyOf(dat, shortBlockLen + 1);
            byte[] ecc = reedSolomonComputeRemainder(dat, rsDiv);
            System.arraycopy(ecc, 0, block, block.length - blockEccLen,
                    ecc.length);
            blocks[i] = block;
        }
        // Interleave (not concatenate) the bytes from every block into a single
        // sequence
        byte[] result = new byte[rawCodewords];
        for (int i = 0, k = 0; i < blocks[0].length; i++)
        {
            for (int j = 0; j < blocks.length; j++)
            {
                // Skip the padding byte in short blocks
                if (i != shortBlockLen - blockEccLen || j >= numShortBlocks)
                {
                    result[k] = blocks[j][i];
                    k++;
                }
            }
        }
        return result;
    }

    private static int getNumRawDataModules(int ver)
    {
        int size = ver * 4 + 17;
        int result = size * size; // Number of modules in the whole QR Code
                                  // square
        result -= 8 * 8 * 3; // Subtract the three finders with separators
        result -= 15 * 2 + 1; // Subtract the format information and dark module
        result -= (size - 16) * 2; // Subtract the timing patterns (excluding
                                   // finders)
        // The five lines above are equivalent to: int result = (16 * ver + 128)
        // * ver + 64;
        if (ver >= 2)
        {
            int numAlign = ver / 7 + 2;
            result -= (numAlign - 1) * (numAlign - 1) * 25; // Subtract
                                                            // alignment
                                                            // patterns not
                                                            // overlapping with
                                                            // timing patterns
            result -= (numAlign - 2) * 2 * 20; // Subtract alignment patterns
                                               // that overlap with timing
                                               // patterns
            // The two lines above are equivalent to: result -= (25 * numAlign -
            // 10) * numAlign - 55;
            if (ver >= 7)
                result -= 6 * 3 * 2; // Subtract version information
        }
        assert 208 <= result && result <= 29648;
        return result;
    }

    // Returns a Reed-Solomon ECC generator polynomial for the given degree.
    // This could be
    // implemented as a lookup table over all possible parameter values, instead
    // of as an algorithm.
    private static byte[] reedSolomonComputeDivisor(int degree)
    {
        if (degree < 1 || degree > 255)
            throw new IllegalArgumentException("Degree out of range");
        // Polynomial coefficients are stored from highest to lowest power,
        // excluding the leading term which is always 1.
        // For example the polynomial x^3 + 255x^2 + 8x + 93 is stored as the
        // uint8 array {255, 8, 93}.
        byte[] result = new byte[degree];
        result[degree - 1] = 1; // Start off with the monomial x^0
        // Compute the product polynomial (x - r^0) * (x - r^1) * (x - r^2) *
        // ... * (x - r^{degree-1}),
        // and drop the highest monomial term which is always 1x^degree.
        // Note that r = 0x02, which is a generator element of this field
        // GF(2^8/0x11D).
        int root = 1;
        for (int i = 0; i < degree; i++)
        {
            // Multiply the current product by (x - r^i)
            for (int j = 0; j < result.length; j++)
            {
                result[j] = (byte) reedSolomonMultiply(result[j] & 0xFF, root);
                if (j + 1 < result.length)
                    result[j] ^= result[j + 1];
            }
            root = reedSolomonMultiply(root, 0x02);
        }
        return result;
    }

    // Returns the product of the two given field elements modulo GF(2^8/0x11D).
    // The arguments and result
    // are unsigned 8-bit integers. This could be implemented as a lookup table
    // of 256*256 entries of uint8.
    private static int reedSolomonMultiply(int x, int y)
    {
        assert x >> 8 == 0 && y >> 8 == 0;
        // Russian peasant multiplication
        int z = 0;
        for (int i = 7; i >= 0; i--)
        {
            z = (z << 1) ^ ((z >>> 7) * 0x11D);
            z ^= ((y >>> i) & 1) * x;
        }
        assert z >>> 8 == 0;
        return z;
    }

    //// Returns the Reed-Solomon error correction codeword for the given data
    //// and divisor polynomials.
    private static byte[] reedSolomonComputeRemainder(byte[] data,
            byte[] divisor)
    {
        byte[] result = new byte[divisor.length];
        for (byte b : data)
        { // Polynomial division
            int factor = (b ^ result[0]) & 0xFF;
            System.arraycopy(result, 1, result, 0, result.length - 1);
            result[result.length - 1] = 0;
            for (int i = 0; i < result.length; i++)
                result[i] ^= reedSolomonMultiply(divisor[i] & 0xFF, factor);
        }
        return result;
    }

    // Draws two copies of the format bits (with its own error correction code)
    // based on the given mask and this object's error correction level field.
    private void drawFormatBits(int msk)
    {
        // Calculate error correction code and pack bits
        int data = errorCorrectionLevel.formatBits << 3 | msk; // errCorrLvl is
                                                               // uint2, mask is
                                                               // uint3
        int rem = data;
        for (int i = 0; i < 10; i++)
            rem = (rem << 1) ^ ((rem >>> 9) * 0x537);
        int bits = (data << 10 | rem) ^ 0x5412; // uint15
        assert bits >>> 15 == 0;
        // Draw first copy
        for (int i = 0; i <= 5; i++)
            setFunctionModule(8, i, getBit(bits, i));
        setFunctionModule(8, 7, getBit(bits, 6));
        setFunctionModule(8, 8, getBit(bits, 7));
        setFunctionModule(7, 8, getBit(bits, 8));
        for (int i = 9; i < 15; i++)
            setFunctionModule(14 - i, 8, getBit(bits, i));
        // Draw second copy
        for (int i = 0; i < 8; i++)
            setFunctionModule(size - 1 - i, 8, getBit(bits, i));
        for (int i = 8; i < 15; i++)
            setFunctionModule(8, size - 15 + i, getBit(bits, i));
        setFunctionModule(8, size - 8, true); // Always dark
    }

    // Returns true iff the i'th bit of x is set to 1.
    static boolean getBit(int x, int i)
    {
        return ((x >>> i) & 1) != 0;
    }

    // Sets the color of a module and marks it as a function module.
    // Only used by the constructor. Coordinates must be in bounds.
    private void setFunctionModule(int x, int y, boolean isDark)
    {
        matrix[x][y].setIsDark(isDark ? 1 : 0);
        isFunction[x][y] = true;
        matrix[x][y].setIsClickable(false);
    }

    private void setDataModule(int x, int y, boolean isDark)
    {
        matrix[x][y].setIsDark(isDark ? 1 : 0);
    }

    // XORs the codeword modules in this QR Code with the given mask pattern.
    // The function modules must be marked and the codeword bits must be drawn
    // before masking. Due to the arithmetic of XOR, calling applyMask() with
    // the same mask value a second time will undo the mask. A final well-formed
    // QR Code needs exactly one (not zero, two, etc.) mask applied.
    private void applyMask(int msk)
    {
        if (msk < 0 || msk > 7)
            throw new IllegalArgumentException("Mask value out of range");
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                boolean invert;
                switch (msk)
                {
                case 0:
                    invert = (x + y) % 2 == 0;
                    break;

                case 1:
                    invert = y % 2 == 0;
                    break;

                case 2:
                    invert = x % 3 == 0;
                    break;

                case 3:
                    invert = (x + y) % 3 == 0;
                    break;

                case 4:
                    invert = (x / 3 + y / 2) % 2 == 0;
                    break;

                case 5:
                    invert = x * y % 2 + x * y % 3 == 0;
                    break;

                case 6:
                    invert = (x * y % 2 + x * y % 3) % 2 == 0;
                    break;

                case 7:
                    invert = ((x + y) % 2 + x * y % 3) % 2 == 0;
                    break;

                default:
                    throw new AssertionError();
                }
                if (invert && !isFunction[x][y])
                    matrix[x][y].flip();
            }
        }
    }

    // Returns an ascending list of positions of alignment patterns for this
    // version number.
    // Each position is in the range [0,177), and are used on both the x and y
    // axes.
    // This could be implemented as lookup table of 40 variable-length lists of
    // unsigned bytes.
    private int[] getAlignmentPatternPositions()
    {
        if (version == 1)
            return new int[] {};
        else
        {
            int numAlign = version / 7 + 2;
            int step = (version == 32) ? 26
                    : (version * 4 + numAlign * 2 + 1) / (numAlign * 2 - 2) * 2;
            int[] result = new int[numAlign];
            result[0] = 6;
            for (int i = result.length - 1,
                    pos = size - 7; i >= 1; i--, pos -= step)
                result[i] = pos;
            return result;
        }
    }

    // Draws two copies of the version bits (with its own error correction
    // code),
    // based on this object's version field, iff 7 <= version <= 40.
    public void drawVersion()
    {
        if (version < 7)
        {
            outputBox.setText("Version#" + version
                    + " - Versionsmuster erst ab Version#7");
            return;
        }
        // Calculate error correction code and pack bits
        int rem = version; // version is uint6, in the range [7, 40]
        for (int i = 0; i < 12; i++)
            rem = (rem << 1) ^ ((rem >>> 11) * 0x1F25);
        int bits = version << 12 | rem; // uint18
        assert bits >>> 18 == 0;
        // Draw two copies
        for (int i = 0; i < 18; i++)
        {
            boolean bit = getBit(bits, i);
            int a = size - 11 + i % 3;
            int b = i / 3;
            setFunctionModule(a, b, bit);
            setFunctionModule(b, a, bit);
        }
        generatePattern();
    }

    private void drawAlignmentPatternSubroutine(int x, int y)
    {
        for (int dy = -2; dy <= 2; dy++)
        {
            for (int dx = -2; dx <= 2; dx++)
                setFunctionModule(x + dx, y + dy,
                        Math.max(Math.abs(dx), Math.abs(dy)) != 1);
        }
    }

    /**
     * The error correction level in a QR Code symbol.
     */
    public enum Ecc
    {
        // Must be declared in ascending order of error protection
        // so that the implicit ordinal() and values() work properly
        /** The QR Code can tolerate about 7% erroneous codewords. */
        LOW(1),
        /** The QR Code can tolerate about 15% erroneous codewords. */
        MEDIUM(0),
        /** The QR Code can tolerate about 25% erroneous codewords. */
        QUARTILE(3),
        /** The QR Code can tolerate about 30% erroneous codewords. */
        HIGH(2);

        // In the range 0 to 3 (unsigned 2-bit integer).
        final int formatBits;

        // Constructor.
        private Ecc(int fb)
        {
            formatBits = fb;
        }
    }

    private static final byte[][] ECC_CODEWORDS_PER_BLOCK = {
            // Version: (note that index 0 is for padding, and is set to an
            // illegal value)
            // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
            // 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
            // 35, 36, 37, 38, 39, 40 Error correction level
            { -1, 7, 10, 15, 20, 26, 18, 20, 24, 30, 18, 20, 24, 26, 30, 22, 24,
                    28, 30, 28, 28, 28, 28, 30, 30, 26, 28, 30, 30, 30, 30, 30,
                    30, 30, 30, 30, 30, 30, 30, 30, 30 }, // Low
            { -1, 10, 16, 26, 18, 24, 16, 18, 22, 22, 26, 30, 22, 22, 24, 24,
                    28, 28, 26, 26, 26, 26, 28, 28, 28, 28, 28, 28, 28, 28, 28,
                    28, 28, 28, 28, 28, 28, 28, 28, 28, 28 }, // Medium
            { -1, 13, 22, 18, 26, 18, 24, 18, 22, 20, 24, 28, 26, 24, 20, 30,
                    24, 28, 28, 26, 30, 28, 30, 30, 30, 30, 28, 30, 30, 30, 30,
                    30, 30, 30, 30, 30, 30, 30, 30, 30, 30 }, // Quartile
            { -1, 17, 28, 22, 16, 22, 28, 26, 26, 24, 28, 24, 28, 22, 24, 24,
                    30, 28, 28, 26, 28, 30, 24, 30, 30, 30, 30, 30, 30, 30, 30,
                    30, 30, 30, 30, 30, 30, 30, 30, 30, 30 }, // High
    };

    private static final byte[][] NUM_ERROR_CORRECTION_BLOCKS = {
            // Version: (note that index 0 is for padding, and is set to an
            // illegal value)
            // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10, 11, 12, 13, 14, 15, 16, 17, 18,
            // 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
            // 35, 36, 37, 38, 39, 40 Error correction level
            { -1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 6, 6, 6, 6, 7, 8, 8,
                    9, 9, 10, 12, 12, 12, 13, 14, 15, 16, 17, 18, 19, 19, 20,
                    21, 22, 24, 25 }, // Low
            { -1, 1, 1, 1, 2, 2, 4, 4, 4, 5, 5, 5, 8, 9, 9, 10, 10, 11, 13, 14,
                    16, 17, 17, 18, 20, 21, 23, 25, 26, 28, 29, 31, 33, 35, 37,
                    38, 40, 43, 45, 47, 49 }, // Medium
            { -1, 1, 1, 2, 2, 4, 4, 6, 6, 8, 8, 8, 10, 12, 16, 12, 17, 16, 18,
                    21, 20, 23, 23, 25, 27, 29, 34, 34, 35, 38, 40, 43, 45, 48,
                    51, 53, 56, 59, 62, 65, 68 }, // Quartile
            { -1, 1, 1, 2, 4, 4, 4, 5, 6, 8, 8, 11, 11, 16, 16, 18, 16, 19, 21,
                    25, 25, 25, 34, 30, 32, 35, 37, 40, 42, 45, 48, 51, 54, 57,
                    60, 63, 66, 70, 74, 77, 81 }, // High
    };

    private void printString(String s, boolean add)
    {
        if (debug)
            System.out.println(s);
        if (add)
            outputBox.addText(s);
        else
            outputBox.setText(s);
    }
}
