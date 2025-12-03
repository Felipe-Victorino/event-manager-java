package view;

public class DisplayText {

	protected void printTitle(){
		System.out.println("==============================");
		System.out.println("            ISOLA");
		System.out.println("==============================");
	}

	protected void printCRUD(String title){
		System.out.println("==============================");
		System.out.println("1 - Create " + title);
		System.out.println("2 - See all " + title);
		System.out.println("3 - Update " + title);
		System.out.println("4 - Delete " + title);
		System.out.println("0 - Back");
		System.out.println("==============================");
	}

	protected void printMenu(){
		System.out.println("==============================");
		System.out.println("1 - Users");
		System.out.println("2 - Events");
		System.out.println("3 - Manage Registers");
		System.out.println("4 - Subscriptions");
		System.out.println("0 - Exit");
		System.out.println("==============================");
	}

	protected void subMenuUsuarios(){
		System.out.println("==============================");
		System.out.println("1 - Search Participant");
		System.out.println("2 - Search Speaker");
		System.out.println("0 - Back");
		System.out.println("==============================");
	}

	protected void subMenuEvents(){
		System.out.println("==============================");
		System.out.println("0 - Show events (Week)");
		System.out.println("0 - Back");
		System.out.println("==============================");
	}

	protected void subMenuRegistros(){
		System.out.println("==============================");

		System.out.println("1 - Manage Event");
		System.out.println("2 - Manage Sessions");
		System.out.println("3 - Manage Rooms");
		System.out.println("4 - Manage Users");
		System.out.println("0 - Back");
		System.out.println("==============================");
	}
}