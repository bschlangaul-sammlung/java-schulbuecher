package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.shared;

/**
 * Schnittstelle für Klienten des Taktgebers.
 *
 * @author Peter Cody
 *
 * @version 1.0
 */
public interface TaktKlient
{
    /**
     * Wird vom Taktgeber für jeden Taktimpuls aufgerufen.
     */
    void TaktImpulsAusfuehren();
}
