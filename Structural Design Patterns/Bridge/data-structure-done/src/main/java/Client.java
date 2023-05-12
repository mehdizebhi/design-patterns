public class Client {

	public static void main(String[] args) {
/*		FifoCollection<String> collection = new Queue<>(
				new SinglyLinkedList<>()
		);*/
		FifoCollection<String> collection = new Queue<>(
				new ArrayLinkedList<>()
		);
		collection.offer("1");
		collection.offer("2");
		collection.offer("3");

		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());

		System.out.println(collection.poll());
	}

}
