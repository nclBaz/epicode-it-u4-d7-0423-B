import entities.User;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);

		User[] usersArray = {aldo, giovanni, giacomo};

		ArrayList<User> usersList = new ArrayList<>(); // Tra le parentesi angolari <> vado a specificare il tipo di dato che sarà conservato nella Lista
		List<User> userList2 = new ArrayList<>(); // UPCASTING. Serve per eventualmente sostituire in futuro in maniera agevole questa ArrayList con un'altra List tipo una LinkedList

		// Aggiunta elementi
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(giacomo);
		usersList.add(0, new User("Ajeje", "Brazorf", 50));

		// Creo una lista a partire da un array
		// ArrayList<User> usersList2 = new ArrayList<>(Arrays.asList(usersArray));

		System.out.println("La lista ha " + usersList.size() + " elementi.");

		for (User user : usersList) {
			System.out.println(user);
		}

		try {
			System.out.println("--------------------------------- GET ---------------------------------");
			User found = usersList.get(1);
			System.out.println("Il secondo elemento della lista è: " + found);
			System.out.println("L'indice di Aldo è: " + usersList.indexOf(aldo));
		} catch (IndexOutOfBoundsException ex) {
			System.err.println(ex.getMessage());
		}

		System.out.println("--------------------------------- CONTAINS ---------------------------------");
		if (usersList.contains(aldo)) { // <-- .contains() internamente utilizza il metodo .equals() degli oggetti in questione, quindi eventualmente posso sovrascriverlo per usare un criterio di comparazione personalizzato
			System.out.println("La lista contiene Aldo");
		} else {
			System.out.println("La lista non contiene Aldo");
		}

		System.out.println("--------------------------------- REMOVE ---------------------------------");
		usersList.remove(0);
		usersList.remove(aldo);
		System.out.println("La lista ha " + usersList.size() + " elementi.");
		for (User user : usersList) {
			System.out.println(user);
		}

		System.out.println("--------------------------------- CLEAR ---------------------------------");
		System.out.println("La lista è vuota? " + usersList.isEmpty()); // Verifico se la lista è vuota o no
		usersList.clear(); // svuoto la lista
		System.out.println("La lista è vuota? " + usersList.isEmpty()); // Verifico se la lista è vuota o no

		System.out.println("--------------------------------- ADD ALL ---------------------------------");
		List<User> newList = new ArrayList<>(Arrays.asList(usersArray));
		usersList.addAll(newList);

		/*		LinkedList<User> newLinkedList = new LinkedList<>();
		newLinkedList.addAll(newList);*/ // Funziona anche sulle LinkedList

		System.out.println("La lista ha " + usersList.size() + " elementi.");
		for (User user : usersList) {
			System.out.println(user);
		}

		System.out.println("--------------------------------- REMOVE ALL ---------------------------------");
		usersList.add(new User("Ajeje", "Brazorf", 50));
		usersList.removeAll(newList); // posso passare una lista di elementi da rimuovere (in questo caso una lista di 3 elementi)
		System.out.println("La lista ha " + usersList.size() + " elementi.");
		for (User user : usersList) {
			System.out.println(user);
		}

		// ****************************************** LINKED LIST ***************************************
	/*	LinkedList<User> linkedListUsers = new LinkedList<>();
		// Qua non sto usando l'UPCASTING, il che vuol dire che potrò usare metodi specifici delle LL e non solo quelli comuni a tutte le List.
		// Di contro non potrò in futuro sostituire in maniera agevole, cambiando una sola riga di codice, una LL con un ArrayList
		linkedListUsers.pollFirst();*/

		// ***************************************** LISTE E TIPI PRIMITIVI *****************************
		ArrayList<Integer> listaNumeri = new ArrayList<>(); // Nelle liste non posso inserire tipi primitivi ma solo oggetti
		// Devo quindi utilizzare le cosiddette WRAPPER CLASSES, ogni tipo primitivo ne ha una corrispondente. Quindi int --> Integer, double --> Double, boolean --> Boolean
		listaNumeri.add(4);

		// *************************************** ITERATORS *******************************************
		ArrayList<String> lettere = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
/*		for (String lettera : lettere) {
			if (lettera.equals("b"))
				lettere.remove(lettera); // Java lancia un'eccezione quando provo a rimuovere un elemento da una lista durante l'iterazione
			else System.out.println(lettera);
		}*/
		// Se voglio rimuovere elementi durante le iterazioni di un ciclo devo usare gli ITERATORS
		Iterator<String> iterator = lettere.iterator();
		while (iterator.hasNext()) { // finchè ci sono ulteriori elementi, continua a ciclare
			String currentLetter = iterator.next(); // .next() mi riestituisce l'elemento corrente
			if (currentLetter.equals("b"))
				iterator.remove(); // N.B. non sto faccendo lettere.remove(), sto facendo iterator.remove()
			else System.out.println(currentLetter);
		}

		// ******************************************************** SET *************************************************
		System.out.println("----------------------------------------- SET --------------------------------------------");
		Set<User> usersSet = new HashSet<>();
		usersSet.add(aldo);
		usersSet.add(giovanni);
		usersSet.add(giacomo);
		usersSet.add(aldo);
		// Java non mi avverte se l'elemento che sto cercando di inserire sia duplicato oppure no. Però il metodo .add() restituisce un boolean, quindi ho modo con un if di verificarlo

		for (User user : usersSet) {
			System.out.println(user);
		}

		Set<String> lettereSet = new TreeSet<>();
		lettereSet.add("f");
		lettereSet.add("b");
		lettereSet.add("c");
		lettereSet.add("a");
		lettereSet.add("f");
		for (String lettera : lettereSet) {
			System.out.println(lettera);
		}

		Set<User> usersTreeSet = new TreeSet<>();
		// Non posso inserire User normali in un TreeSet. Posso farlo solo se la classe User implementa l'interfaccia Comparable
		// Implementare l'interfaccia Comparable significa dover implementare il metodo compareTo che è quello che stabiisce il criterio di ordinamento
		usersTreeSet.add(aldo);
		usersTreeSet.add(giovanni);
		usersTreeSet.add(giacomo);

		for (User user : usersTreeSet) {
			System.out.println(user);
		}

		// ************************************************ MAP ********************************************
	}
}