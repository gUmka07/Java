import java.util.ArrayList;
import java.util.Iterator;
public class Zoo implements Iterable<Animals>{
    private ArrayList<Animals> animals;

    public Zoo() {
        this.animals = new ArrayList<Animals>();
    }

    public void addAnimal(Animals animal){
        this.animals.add(animal);
    }

    public void removeAnimal(int number) {
        this.animals.remove(number - 1);
    }

    public void viewAnimal(int number) {
        System.out.println(this.animals.get(number -1).getClass().getSimpleName());
        System.out.println(this.animals.get(number -1));
    }

    public void makeAnimalSound(int number) {
        this.animals.get(number - 1).makesSound();
        System.out.println();
    }

    public void makeAllSound(){
        for (Animals item: this.animals) {
            System.out.print(item.getClass().getSimpleName() + ": ");
            item.makesSound();
        }
        System.out.println();
    }

    public void printAnimals(){
        System.out.println("Все животные в зоопарке");
        for (int i = 0; i < this.animals.size(); i++) {
            System.out.println((i+1) + "." + this.animals.get(i).getClass().getSimpleName());
            System.out.println(this.animals.get(i));
        }
        System.out.println();
    }

    @Override
    public Iterator<Animals> iterator() {
        return animals.iterator();
    }
}