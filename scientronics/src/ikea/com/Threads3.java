package ikea.com;

import Main.site2panel;

public class Threads3 implements Runnable{
int first;
int end;

	public Threads3(int start, int end) {

	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		System.out.println(first+"     "+end);
		for(int i=first;i<end;i++)
		{
			Productinfo.check(chkdata.datas.get(i));;
			site2panel.pbar1.setValue(site2panel.pbar1.getValue()+1);
		}
		makeThreads3.iscomp();
	}

}