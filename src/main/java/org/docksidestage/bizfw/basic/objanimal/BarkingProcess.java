package org.docksidestage.bizfw.basic.objanimal;

/**
 * @author hakiba
 */
public class BarkingProcess {
    private Animal animal;

    public BarkingProcess(Animal animal) {
        this.animal = animal;
    }

    public BarkedSound execute() {
        animal.breatheIn();
        animal.prepareAbdominalMuscle();
        String barkWord = animal.getBarkWord();
        return animal.doBark(barkWord);
    }
}
