public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }
    void simulate(AbstractDuckFactory duckFactory) {
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        System.out.println("\nDuck Simulator: With Composite - Flocks");
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        Flock flockOfMallards = new Flock();
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);
        flockOfDucks.add(flockOfMallards);
        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);
        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);
        System.out.println("\nThe ducks quacked " +QuackCounter.getQuacks() +   " times");
    }


    private void simulateCounterAndEcho() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());

        Quackable redHeadDecorator = new QuackEcho(new QuackCounter(new RedheadDuck()));

        System.out.println("\nDuck Simulator: With Decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        simulate(pigeonAdapter);
        simulate(redHeadDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateCounterEcho() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countAndEchoDuckFactory = new CounterEchoFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = countingDuckFactory.createRedheadDuck();
        Quackable duckCall = countAndEchoDuckFactory.createDuckCall();
        Quackable rubberDuck = countAndEchoDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: With Abstract Factory");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }


    private void simulateBossFlock() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        BossFlock flock = new BossFlock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);

        flock.quack();
    }
    void simulate(Quackable duck) {
        duck.quack();    }
    }
