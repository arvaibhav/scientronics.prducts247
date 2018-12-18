package ikea.com;

import java.util.ArrayList;

import Main.site2panel;

public class makeThreads3 {
	static ArrayList<Thread> threads = new ArrayList<>(30);
	static int chkstatus = 0;

	public static void main(String[] args) {
		start(30, 421);
	}

	public static void iscomp() {
		if (--chkstatus == 0) {

			site2panel.complete();
		}
	}

	public static void start(int power, int length) {
		threads.clear();
		int len = length;
		// TODO Auto-generated constructor stub
		int chk = (int) Math.ceil(len / (power * 1.0));
		int threadsno = power;
		if (power > len)
			threadsno = len;
		int temp = 0;
		for (int i = 0; i < threadsno; i++) {
			if (len > chk) {
				threads.add(new Thread(new Threads3(temp, (temp + chk))));
				temp = temp + chk;
				len = len - chk;

			} else {
				threads.add(new Thread(new Threads3(temp, length)));
				break;
			}
		}
		chkstatus = threads.size();
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
			;

		}

	}

}
