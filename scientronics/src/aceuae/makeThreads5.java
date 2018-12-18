package aceuae;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Main.site3panel;
import Tool.comparetool1;

public class makeThreads5 {
	static FirefoxOptions op = new FirefoxOptions();
	static int ch = 0;
	static int cn = 1;
	static FirefoxDriver[] driver = new FirefoxDriver[2];
	static ArrayList<Thread> threads = new ArrayList<>(30);

	static void com() {
		site3panel.pbar2.setValue(site3panel.pbar2.getMaximum());
		if (ch-- == 1) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe");
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Csv.save2();
			} catch (Exception e) {
			}

			try {
				site3panel.status.setText("[making compare sheet]");

				comparetool1.make2();
				site3panel.status.setText("[compare sheet done!!]");

			} catch (Exception e2) {
				// TODO: handle exception
			}
			site3panel.st3();
		}

	}

	public static void start() {
		op.setHeadless(true);
		ch = 2;
		int length = datastorage.purls2.size();
		if (length == 0) {
			ch = 1;
			com();
			return;
		}
		site3panel.status.setText("[starting_firefox for n pages]");
		Thread w1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						driver[0] = new FirefoxDriver(op);
						break;
					} catch (Exception e) {
					}
				}

			}
		});
		w1.start();
		Thread w2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						driver[1] = new FirefoxDriver(op);
						break;
					} catch (Exception e) {
					}
				}

			}
		});
		w2.start();
		try {
			w1.join();
			try {
				w2.join();

			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		site3panel.pbar2.setMaximum(site3panel.pbar2.getValue() + length);
		threads.clear();
		threads.add(new Thread(new Threads5(0, (int) length / 2, driver[0])));
		threads.add(new Thread(new Threads5((int) length / 2, length, driver[1])));

		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}

	}

}
