package mini.mafia;

public class Demonstrator {

    public static void main(String[] args) {

        CommercialDepartment commercialDepartment = new CommercialDepartment();
        RecruitmentDepartment recruitmentDepartment = new RecruitmentDepartment();
        SpecialOperationsDepartment specialOperationsDepartment = new SpecialOperationsDepartment();
        Management management = new Management();

        System.out.println("Departament handlowy:");
        commercialDepartment.work();
        System.out.println();
        System.out.println("Departament rekrutacyjny:");
        recruitmentDepartment.work();
        System.out.println();
        System.out.println("Departament operacji specjalnych:");
        specialOperationsDepartment.work();
        System.out.println();
        System.out.println("Zarzad:");
        management.work();

    }

}
