package nio.texts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //CREATE AND WRITE A NEW FILE WITH STRING
//        String text = "Quod equidem non reprehendo;\n" +
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quibus natura iure responderit non esse verum aliunde finem beate vivendi, a se principia rei gerendae peti; Quae enim adhuc protulisti, popularia sunt, ego autem a te elegantiora desidero. Duo Reges: constructio interrete. Tum Lucius: Mihi vero ista valde probata sunt, quod item fratri puto. Bestiarum vero nullum iudicium puto. Nihil enim iam habes, quod ad corpus referas; Deinde prima illa, quae in congressu solemus: Quid tu, inquit, huc? Et homini, qui ceteris animantibus plurimum praestat, praecipue a natura nihil datum esse dicemus?\n" +
//                "\n" +
//                "Iam id ipsum absurdum, maximum malum neglegi. Quod ea non occurrentia fingunt, vincunt Aristonem; Atqui perspicuum est hominem e corpore animoque constare, cum primae sint animi partes, secundae corporis. Fieri, inquam, Triari, nullo pacto potest, ut non dicas, quid non probes eius, a quo dissentias. Equidem e Cn. An dubium est, quin virtus ita maximam partem optineat in rebus humanis, ut reliquas obruat?\n" +
//                "\n" +
//                "Quis istum dolorem timet?\n" +
//                "Summus dolor plures dies manere non potest? Dicet pro me ipsa virtus nec dubitabit isti vestro beato M. Tubulum fuisse, qua illum, cuius is condemnatus est rogatione, P. Quod si ita sit, cur opera philosophiae sit danda nescio.\n" +
//                "\n" +
//                "Ex eorum enim scriptis et institutis cum omnis doctrina liberalis, omnis historia.\n" +
//                "Quod si ita est, sequitur id ipsum, quod te velle video, omnes semper beatos esse sapientes. Cum enim fertur quasi torrens oratio, quamvis multa cuiusque modi rapiat, nihil tamen teneas, nihil apprehendas, nusquam orationem rapidam coerceas. Ita redarguitur ipse a sese, convincunturque scripta eius probitate ipsius ac moribus. At quanta conantur! Mundum hunc omnem oppidum esse nostrum! Incendi igitur eos, qui audiunt, vides. Vide, ne magis, inquam, tuum fuerit, cum re idem tibi, quod mihi, videretur, non nova te rebus nomina inponere. Qui-vere falsone, quaerere mittimus-dicitur oculis se privasse; Si ista mala sunt, in quae potest incidere sapiens, sapientem esse non esse ad beate vivendum satis. At vero si ad vitem sensus accesserit, ut appetitum quendam habeat et per se ipsa moveatur, quid facturam putas?\n" +
//                "\n" +
//                "Quem si tenueris, non modo meum Ciceronem, sed etiam me ipsum abducas licebit.\n" +
//                "Stulti autem malorum memoria torquentur, sapientes bona praeterita grata recordatione renovata delectant.\n" +
//                "Esse enim quam vellet iniquus iustus poterat inpune.\n" +
//                "Quae autem natura suae primae institutionis oblita est?\n" +
//                "Verum tamen cum de rebus grandioribus dicas, ipsae res verba rapiunt;\n" +
//                "Hoc est non modo cor non habere, sed ne palatum quidem.\n" +
//                "Voluptatem cum summum bonum diceret, primum in eo ipso parum vidit, deinde hoc quoque alienum; Sed tu istuc dixti bene Latine, parum plane. Nam haec ipsa mihi erunt in promptu, quae modo audivi, nec ante aggrediar, quam te ab istis, quos dicis, instructum videro. Fatebuntur Stoici haec omnia dicta esse praeclare, neque eam causam Zenoni desciscendi fuisse. Non autem hoc: igitur ne illud quidem. Ratio quidem vestra sic cogit. Cum audissem Antiochum, Brute, ut solebam, cum M. An quod ita callida est, ut optime possit architectari voluptates?\n" +
//                "\n" +
//                "Idemne, quod iucunde?\n" +
//                "Haec mihi videtur delicatior, ut ita dicam, molliorque ratio, quam virtutis vis gravitasque postulat. Sed quoniam et advesperascit et mihi ad villam revertendum est, nunc quidem hactenus; Cuius ad naturam apta ratio vera illa et summa lex a philosophis dicitur. Neque solum ea communia, verum etiam paria esse dixerunt. Sed nunc, quod agimus; A mene tu?";
//        try {
//            OpenOption[] openOptions = {StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
//            Path path = Path.of("Files/Text/savedText.txt");
//            Files.write(path, text.getBytes(StandardCharsets.UTF_8), openOptions);
//        } catch (IOException e){
//        }

        //READ FILES and convert into String
//        String empty = "";
//        try {
//            OpenOption [] openOptions = {StandardOpenOption.READ};
//            Path path = Path.of("Files/Text/savedText.txt");
//            empty  = Files.readString(path);
//            System.out.println(empty);
//        } catch (IOException e){
//        }

        //ЗЧИТУВАННЯ КОЖНОГО РЯДКА В ЛИСТ
//        Path path = Path.of("Files/Text/savedText.txt");
//        try {
//            List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
//        } catch (IOException e){
//        }
        //ЗЧИТУВАННЯ ВЕЛИКИХ ФАЙЛІВ (ТЕКСТУ)
        Path path = Path.of("Files/Text/savedText.txt");
        Path path1 = Path.of("Files/Text/newText.txt");
        OpenOption [] openOptionReader = {StandardOpenOption.READ};
        OpenOption [] openOptionsWriter = {StandardOpenOption.CREATE, StandardOpenOption.WRITE};
        try (BufferedReader reader = Files.newBufferedReader(path); BufferedWriter writer = Files.newBufferedWriter(path1)) {
            String empty = "";
            while((empty = reader.readLine()) != null){
                writer.append(empty + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
