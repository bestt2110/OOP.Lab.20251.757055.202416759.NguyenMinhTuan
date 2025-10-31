package Aims;
public class TestingPassingParameter {
//swap method before being fixed
    /*public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }*/

	//after fixed
	public static void main(String[] args) {
	    DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
	    DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
	
	    DigitalVideoDisc[] dvdList = {jungleDVD, cinderellaDVD};
	
	    swap(dvdList, 0, 1);
	
	    jungleDVD = dvdList[0];
	    cinderellaDVD = dvdList[1];
	
	    System.out.println("jungleDVD title: " + jungleDVD.getTitle());
	    System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());
	}
	
	public static void swap(DigitalVideoDisc[] arr, int i, int j) {
	    DigitalVideoDisc tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;
	}
}