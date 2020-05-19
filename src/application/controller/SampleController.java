package application.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import application.Parser;
import application.model.DateDeathRapport;
import application.model.DateRapport;
import application.model.Rapport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SampleController {

	@FXML
	private TableView<Rapport> tvCorona;

	@FXML
	private TableColumn<Rapport, Integer> tcNew;

	@FXML
	private TableColumn<Rapport, Integer> tcTotal;

	@FXML
	private TableColumn<Rapport, Float> tcAttachRate;

	@FXML
	private Button btnGet;

	@FXML
	private TableColumn<Rapport, String> tcConry;

	@FXML
	private TableColumn<Rapport, Integer> tcTDeaths;

	@FXML
	private TableColumn<Rapport, Integer> tcNDeath;

	@FXML
	private TableColumn<Rapport, Float> tcMortaily;

	@FXML
	private TextField url;

	@FXML
	private TableColumn<Rapport, Integer> tcpopulation;

	@FXML
	private MenuItem mINewCases;
	@FXML
	private StackedBarChart<String, Integer> stackedBarChart;

	@FXML
	private MenuItem mINewDeaths;
	
	@FXML
    private MenuItem mCases;
	ObservableList<Rapport> list = FXCollections.observableArrayList();
	public static Parser p;

	@FXML
	public void initialize() {
		tcConry.setCellValueFactory((new PropertyValueFactory<Rapport, String>("contry")));
		tcTotal.setCellValueFactory(new PropertyValueFactory<Rapport, Integer>("total"));
		tcNew.setCellValueFactory(new PropertyValueFactory<Rapport, Integer>("newCases"));
		tcNDeath.setCellValueFactory(new PropertyValueFactory<Rapport, Integer>("newdeath"));
		tcAttachRate.setCellValueFactory(new PropertyValueFactory<Rapport, Float>("attackRate"));
		tcMortaily.setCellValueFactory(new PropertyValueFactory<Rapport, Float>("mortaility"));
		tcpopulation.setCellValueFactory(new PropertyValueFactory<Rapport, Integer>("population"));
		tcTDeaths.setCellValueFactory(new PropertyValueFactory<Rapport, Integer>("totalDeaths"));
		

	}

	@FXML
	void getData(javafx.event.ActionEvent event) throws ParserConfigurationException, SAXException, ParseException {
		try {
			//Data link used : https://opendata.ecdc.europa.eu/covid19/casedistribution/xml/
			if(url.getText() != null  && url.getText().length()>0)
			p = new Parser(url.getText());
			else
				p=new Parser("https://opendata.ecdc.europa.eu/covid19/casedistribution/xml/");
			p = new Parser(url.getText());
			list.clear();
			list.addAll(p.readFile());
			tvCorona.setItems(list);

		} catch (NumberFormatException | DOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void showCases(ActionEvent event) throws NumberFormatException, DOMException, ParserConfigurationException,
			SAXException, IOException, ParseException {
		ObservableList<DateRapport> rapport = p.readFile2();

		Stage primaryStage = new Stage();
		primaryStage.setTitle("StackedBarChart continenteriments");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("date");

		for (Date s : rapport.get(0).getValues().keySet()) {

			xAxis.getCategories().add(df.format(s));
		}

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Cases");

		stackedBarChart = new StackedBarChart(xAxis, yAxis);

		for (DateRapport r : rapport) {
			XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series();
			dataSeries1.setName(r.getContinent());

			for (Date s : r.getValues().keySet())

			{

				if (df.format(s).contains("/05") || df.format(s).contains("/04") || df.format(s).contains("/03"))
					dataSeries1.getData().add(new XYChart.Data<String, Integer>(df.format(s), r.getValues().get(s)));

			}
			if (dataSeries1.getData().size() > 0)
				stackedBarChart.getData().add(dataSeries1);

		}
		VBox vbox = new VBox(stackedBarChart);

		Scene scene = new Scene(vbox, 400, 200);

		primaryStage.setScene(scene);
		primaryStage.setHeight(300);
		primaryStage.setWidth(1200);

		primaryStage.show();

	}

	@FXML
	void shoowDeaths(ActionEvent event) throws NumberFormatException, DOMException, ParserConfigurationException,
			SAXException, IOException, ParseException {
		System.out.println("hello");
		ObservableList<DateDeathRapport> rapport = p.readFile3();

		Stage primaryStage = new Stage();
		primaryStage.setTitle("StackedBarChart continenteriments");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("date");

		for (Date s : rapport.get(0).getValues().keySet()) {

			xAxis.getCategories().add(df.format(s));
		}

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Dethes");

		stackedBarChart = new StackedBarChart(xAxis, yAxis);

		for (DateDeathRapport r : rapport) {
			XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series();
			dataSeries1.setName(r.getContinent());

			for (Date s : r.getValues().keySet())

			{

				if (df.format(s).contains("/05") || df.format(s).contains("/04") || df.format(s).contains("/03"))
					dataSeries1.getData().add(new XYChart.Data<String, Integer>(df.format(s), r.getValues().get(s)));

			}
			if (dataSeries1.getData().size() > 0)
				stackedBarChart.getData().add(dataSeries1);

		}
		VBox vbox = new VBox(stackedBarChart);

		Scene scene = new Scene(vbox, 400, 200);

		primaryStage.setScene(scene);
		primaryStage.setHeight(300);
		primaryStage.setWidth(1200);

		primaryStage.show();

	}

}
