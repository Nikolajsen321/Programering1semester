package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {


	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		Tab tabForside = new Tab("Forside");
		tabPane.getTabs().add(tabForside);

		ForsidePane forsidePane = new ForsidePane(tabPane);
		tabForside.setContent(forsidePane);
		tabForside.setClosable(false);

		//------------------------------------------------------------------------------------------

		Tab tabKonference = new Tab("Konference-oversigt");
		tabPane.getTabs().add(tabKonference);

		KonferencePane konferencePane = new KonferencePane();
		tabKonference.setContent(konferencePane);
		//tabKonference.setOnSelectionChanged(event -> konferencePane.updateControls());
		tabKonference.setClosable(false);

		//------------------------------------------------------------------------------------------

		Tab tabTilmelding = new Tab("Tilmelding");
		tabPane.getTabs().add(tabTilmelding);

		TilmeldingPane tilmeldingPane = new TilmeldingPane();
		tabTilmelding.setContent(tilmeldingPane);
		tabTilmelding.setClosable(false);

		//------------------------------------------------------------------------------------------

		Tab tabHotel = new Tab("Hotel-oversigt");
		tabPane.getTabs().add(tabHotel);

		HotelPane hotelPane = new HotelPane();
		tabHotel.setContent(hotelPane);
		tabHotel.setClosable(false);

		//------------------------------------------------------------------------------------------

		Tab tabAdmin = new Tab("Administration");
		tabPane.getTabs().add(tabAdmin);

		AdminPane adminPane = new AdminPane();
		tabAdmin.setContent(adminPane);
		tabAdmin.setClosable(false);




	}

}
