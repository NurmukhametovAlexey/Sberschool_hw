package ru.sbrf.lesson3.zoo.animal;

public class Tests {

    public void testAllAnimals() {
        Bear bear = new Bear("Bear1", 10);
        Lion lion = new Lion("Lion1", 20);
        Wolf wolf = new Wolf("Wolf1", 15);
        Monkey monkey = new Monkey("Monkey1", 7);
        Zebra zebra = new Zebra("Zebra1", 30);
        Duck duck = new Duck("Duck1", 3);
        Parrot parrot = new Parrot("Parrot1", 1);

        Animal[] animalsToTest = {bear, lion, wolf, monkey, zebra, duck, parrot};

        Tests animalTests = new Tests();

        for (Animal animal: animalsToTest) {
            System.out.println("\nTesting animal " + animal.toString());

            testAnimal(animal);
            if (animal instanceof Walkable)
                testWalkable((Walkable) animal);
            if (animal instanceof Swimmable)
                testSwimmable((Swimmable) animal);
            if (animal instanceof Flyable)
                testFlyable((Flyable) animal);
            if (animal instanceof Vegetarian)
                testVegetarian((Vegetarian) animal);
            if (animal instanceof Dangerous)
                testDangerous((Dangerous) animal);
        }
    }

    public void testAnimal(Animal animal) {
        System.out.println("animal.getName()\n" + animal.getName());
        System.out.println("animal.getAge()\n" + animal.getAge());
        System.out.println("animal.say()...");
        animal.say();
        System.out.println("animal.feed()...");
        animal.feed();
        System.out.println("animal.feed(treats)...");
        animal.feed("treats");
        System.out.println("animal.celebrateBDay()...");
        animal.celebrateBDay();
    }
    public void testWalkable(Walkable walkable) {
        System.out.println("walkable.walk()...");
        walkable.walk();
    }

    public void testSwimmable(Swimmable swimmable) {
        System.out.println("swimmable.swim()...");
        swimmable.swim();
    }

    public void testFlyable(Flyable flyable) {
        System.out.println("flyable.fly()...");
        flyable.fly();
        System.out.println("flyable.land()...");
        flyable.land();
    }

    public void testVegetarian(Vegetarian vegetarian) {
        System.out.println("vegetarian.eatFromVisitor()");
        vegetarian.eatFromVisitor();
    }

    public void testDangerous(Dangerous dangerous) {
        System.out.println("dangerous.attack()");
        dangerous.attack();
    }
}
