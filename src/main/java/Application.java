import com.alex.model.session.SessionManager;
import com.alex.view.MyView;

public class Application {

  public static void main(String[] args) {
    SessionManager.openSession();
    MyView myView = new MyView();
    myView.print();
    SessionManager.closeSession();

  }
}
