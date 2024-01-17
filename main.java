import java.util.ArrayList;

class Fruit {
    // родительский класс для фруктов
}

class Apple extends Fruit {
    // класс для яблок
}

class Orange extends Fruit {
    // класс для апельсинов
}

class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0;
        }
        float weight = fruits.get(0) instanceof Apple ? 1.0f : 1.5f;
        return weight * fruits.size();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transferFruitsToAnotherBox(Box<T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        if (this.fruits.get(0).getClass() != anotherBox.fruits.get(0).getClass()) {
            throw new IllegalArgumentException("Нельзя пересыпать фрукты разных типов");
        }
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
