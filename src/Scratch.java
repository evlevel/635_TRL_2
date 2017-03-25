import java.util.ArrayList;

public class Scratch
{

	public static void main(String[] args)
	{
		int x;
		StdOut.println("hello");
		Integer i;

		ArrayList<Number> foo = new ArrayList<>();

		foo.add(1);
		foo.add(47.0);
		foo.add(47.0f);
		StdOut.println(foo.get(1).equals(foo.get(2)));

		// foo.add('a');
		StdOut.println(foo);

		foo.remove(47.0);
		StdOut.println(foo);

		i = 47;
	}

}
