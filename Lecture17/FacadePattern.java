package Lecture17;


// sub-systems
class PowerSupply {
    public void providePower() {
        System.out.println("Power Supply : Providing power ...");
    }
}

class CoolingSystem {
    public void startFans() {
        System.out.println("Cooling System : Fans started...");
    }
}

class CPU {
    public void initialize() {
        System.out.println("CPU : Initialization started ...");
    }
}

class Memory {
    public void initialize() {
        System.out.println("Memory : Initialization started ...");
    }
}

class HardDrive {
    public void spinUp() {
        System.out.println("HardDrive : Spinning up...");
    }
}

class BIOS {
    public void boot(CPU cpu, Memory memory) {
        System.out.println("BIOS : Booting CPU and Memory ...");
        cpu.initialize();
        memory.initialize();
    }
}

class OperatingSystem {
    public void load() {
        System.out.println("OperatingSystem : Loading into memory ...");
    }
}

// facade class
class ComputerFacade {
    private PowerSupply powerSupply = new PowerSupply();
    private CoolingSystem coolingSystem = new CoolingSystem();
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();
    private BIOS bios = new BIOS();
    private OperatingSystem os = new OperatingSystem();
    
    public void startComputer () {
        System.out.println("--------------Starting Computer-----------------");
        powerSupply.providePower();
        coolingSystem.startFans();
        bios.boot(cpu, memory);
        hardDrive.spinUp();
        os.load();
    }

}


public class FacadePattern {

    // Client code
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}
