package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Daniel
 */
public class lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<p> list1 = new ArrayList<>();
        list1.add(new p("Daniel", "2", "Zamora"));
        list1.add(new p("Daniel", "3", "Zamora"));
        list1.add(new p("Daniel", "1", "Zamora"));
        list1.add(new p("Daniel", "4", "Zamora"));

        Collection<p> listOne = list1;

        List<p> list2 = new ArrayList<>();
        list2.add(new p("Daniel", "2", "Zamora"));
        list2.add(new p("Daniel", "1", "Zamora"));
        list2.add(new p("Daniel", "4", "Zamora"));

//        Set<p> interseccion = new HashSet<p>(list1);
//        interseccion.retainAll(list2);
//        System.out.println(interseccion);
        Collection<p> listTwo = list2;

        Collection<p> similar = new HashSet<p>(listOne);
        Collection<p> different = new HashSet<p>();
        different.addAll(listOne);
        different.addAll(listTwo);

        similar.retainAll(listTwo);
        different.removeAll(similar);

        System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", listOne, listTwo, similar, different);

    }

}

class p {

    private String nombre;
    private String Id;
    private String Apellido;

    public p(String nombre, String Id, String Apellido) {
        this.nombre = nombre;
        this.Id = Id;
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

}
