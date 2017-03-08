package clazz;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class Activity {

	private String name;
	private boolean isRunning = true;
	private Handler handler = new Handler();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void onCreate() {
		
	}
	
	public void onRunning() {
//      This is UI Thread;
		while(isRunning) {
//			handler.setMassage("hi my name is Mia");
			handler.handleMassage();
			
			
			
		}
		
		
	}

	public void onStart() {

	}
	
	public void onFinish() {
		isRunning = false;
	}

	public void onStop() {
		Intent intent = new Intent(Activity.this, MiaActivity.class);
		intent.startActivity();
	}

	public void onDestory() {

	}
	
	public class MiaActivity extends Activity {
		@Override
		public void onCreate() {
			super.onCreate();
		}
		
		@Override
		public void onDestory() {
			super.onDestory();
		}
	}
	
	public static void main(String[] args) {
		Activity activity = new Activity();
		activity.onCreate();
		activity.onStart();
		activity.onStop();
		activity.onDestory();
	}
	
	private class Handler {
		Queue<Runnable> queue = new LinkedBlockingQueue<>();
		
		public void setMassage() {
			queue.add(message);
		}
		
		public void handleMassage() {
			runnable.run();
			queue.poll();
		}
		
		public void 
	}

	private static class Intent {
		private Activity parent;

		public Intent(Activity activity, Class<? extends Activity> c) {
			try {

				System.out.println(c.getName());

				parent = c.newInstance();

				parent.setName("father");
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		public void printName() {
			System.out.println(parent.getName());
		}
		
		public void startActivity() {
			
		}
	}
}
