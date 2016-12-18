package clone;

public class SolutionClone {

	public static void main(String[] args) {
		Novel novel = new Novel();
		Novel novel2 =  novel.clone();
		novel2.price = 200;
		
		System.out.println(novel);
		System.out.println(novel2);
		
		
		novel.note.word = "Novel book";
		
		System.out.println(novel);
		System.out.println(novel2);
		
	}

	private static class Book {
		String name = "herry";
		int id = 12345;
	}
	
	private static class Novel extends Book implements Cloneable {
		private int price = 100;
		private Note note = new Note();
		
		@Override
		protected Novel clone()  {
			try {
				Novel novel = (Novel) super.clone();
				note = note.clone();
				return novel;
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public String toString() {
			return String.format(name + " id : %05d price : %03d note : " + note.word, id, price);
		}
	}
	 
	private static class Note implements Cloneable {
		String word = "Hello Word";
		@Override
		protected Note clone() throws CloneNotSupportedException {
			return (Note) super.clone();
		}
	}
	
}
