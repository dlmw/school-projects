package ch.ansermgw.angryword.provider;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.activities.Play;
import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.models.SemanticWord;
import ch.ansermgw.angryword.resource.VocabularyResource;

import java.util.ArrayList;
import java.util.List;

public class VocabularyProvider {
    private static VocabularyProvider instance;
    private List<VocabularyResource> vocabularies;
    private List<Language> languages;

    private VocabularyProvider() {
        languages = new ArrayList<>();
        languages.addAll(LanguageProvider.getInstance().getLanguages());
        vocabularies = new ArrayList<>();
        SemanticWord sw;
        VocabularyResource voc = new VocabularyResource("L'argent");

        try {
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la banque"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the bank"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el Banco"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"l''argent liquide"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"cash"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"efectivo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le paiement"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"payment"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"pago"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un carnet de chèques"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"checkbook"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"talonario de cheques"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"déposer de l''argent"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"to deposit money"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"depositar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"prêter de l''argent"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"to borrow money"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"pedir dinero prestado"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"les services financiers"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"financial services"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"servicios financieros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la commission"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"commission"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"comisión"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un investissement"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"an investment"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una inversión"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un virement"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"transfer"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"transferir"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la gestion de l''argent"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"money management"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"administración del dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une transaction"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a transaction"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una transacción"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un guichet automatique"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"ATM machine"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"cajero automático"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"attendre dans la queue"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"to wait in line"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"a esperar en línea"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une carte bancaire"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"banking/ATM card"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"tarjeta bancaria / ATM"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"faire des économies"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"to save money"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"para ahorrar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le montant"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"sum/total amount"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"suma / monto total"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un compte-chèques"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"checking account"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"cuenta de cheques"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"l''argent"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"money"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"les fonds"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"funds"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"fondos"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un chèque"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"check"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"cheque"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un dépôt"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"deposit"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"depositar"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le crédit"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"credit"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"crédito"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"les marchés financiers"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"financial markets"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"mercados financieros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la clientèle"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"clientele"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"clientela"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"les frais"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"fees"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"Tarifa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une institution financière"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"financial institution"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"institución financiera"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le taux d''intérêt"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"interest rate"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"tasa de interés"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la monnaie"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"currency"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"moneda"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le bilan"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"balance"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"equilibrar"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"prendre un numéro"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"to take a number"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"tomar un número"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une carte de crédit"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"credit card"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"tarjeta de crédito"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un emprunt"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a loan"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un préstamo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"retirer de l''argent"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"to take out money"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"sacar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un compte d''épargne"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"savings account"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"cuenta de ahorros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un distributeur automatique"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"ATM machine"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"cajero automático"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un reçu"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"receipt"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"recibo"); voc.addSemanticWord(sw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        vocabularies.add(voc);

        voc = new VocabularyResource("Les meubles");

        try {
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une table"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a table"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una mesa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une chaise"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a chair"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una silla"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une bibliothèque"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a bookcase"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una estantería"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une table basse"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a coffee table"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una mesa para cafe"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une cheminée"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a fireplace"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una chimenea"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une table de chevet"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a bedside table"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una mesita de noche"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une étagère"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a shelf"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un estante"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une armoire"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a wardrobe"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un armario"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une commode"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a dresser"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un vestidor"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"une moquette"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a carpet"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"Una alfombra"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un siège"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a seat"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un asiento"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un tabouret"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a stool"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un taburete"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un placard"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a cupboard"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un armario"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un tiroir"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a drawer"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un cajon"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un fauteuil"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a armchair"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un sillón"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un lit"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a bed"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una cama"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un bureau"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a desk"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un escritorio"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un miroir"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a mrror"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un mrror"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un meuble"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a piece of furniture"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"un mueble"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"un oreiller"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"a pillow"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"una almohada"); voc.addSemanticWord(sw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vocabularies.add(voc);

        voc = new VocabularyResource("Les couleurs");

        try {
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"blanc"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"white"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"blanco"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"bleu clair"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"light blue"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"azul claro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"multicolore"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"muli-colored"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"multicolor"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"gris"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"grey"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"gris"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"vert"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"green"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"verde"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"noir"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"black"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"negro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"argenté"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"silver"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"plata"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"jaune"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"yellow"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"amarillo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"orange"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"orange"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"naranja"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"bleu"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"blue"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"azul"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"bleu foncé"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"dark blue"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"azul oscuro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"rose"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"pink"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"rosado"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"rouge"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"red"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"rojo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"marron"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"brown"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"marrón"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"violet"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"purple"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"púrpura"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"beige"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"beige"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"beige"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"turquoise"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"turquoise"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"turquesa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"doré"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"golden"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"dorado"); voc.addSemanticWord(sw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vocabularies.add(voc);

        voc = new VocabularyResource("La famille");

        try {
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le père"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the father"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el padre"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"les parents"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the parents"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"los padres"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la sœur"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the sister"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"la hermana"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la fille"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the daughter"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"la hija"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le bébé"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the baby"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el bebé"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la femme"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the wife"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"La esposa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la fiancée"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the fiancée"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"la prometida"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la grand-mère"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the grandmother"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"la abuela"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"les petits-enfants"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the grandchildren"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"los nietos"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la tante"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the aunt"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"la tía"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la nièce"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the niece"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"la sobrina"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la belle-mère"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the step mother"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"La Madrastra"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la cousine"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the cousin (female)"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"la prima (mujer)"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la belle-sœur"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"sister in-law"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"cuñada"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"la mère"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the mother"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"La madre"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le frère"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the brother"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el hermano"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le fils"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the son"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el hijo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"l’enfant"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the child"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el niño"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le mari"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the husband"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el esposo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le fiancé"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the fiancé"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el prometido"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le grand-père"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the grandfather"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el abuelo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"les grand-parents"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the grandparents"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"los abuelos"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"l’oncle"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the uncle"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el tío"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le neveu"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the nephew"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el sobrino"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le beau-père"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the step father"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el padrastro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le cousin"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"the cousin (male)"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"el primo (hombre)"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le beau-frère"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"brother in-law"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"cuñado"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(LanguageProvider.getInstance().getLanguage("fr"),"le beau-père"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("en"),"father in-law"); sw.addTranslation(LanguageProvider.getInstance().getLanguage("es"),"suegro"); voc.addSemanticWord(sw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vocabularies.add(voc);
    }

    public static VocabularyProvider getInstance() {
        if (instance == null)
            VocabularyProvider.instance = new VocabularyProvider();

        return instance;
    }

    public VocabularyResource getRandomVocabulary() {
        return vocabularies.get(AngrywordMain.getInstance().getRand().nextInt(vocabularies.size()));
    }
}
