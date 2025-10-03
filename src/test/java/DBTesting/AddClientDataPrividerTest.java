package DBTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static util.Conversions.getCountry;
import static util.Conversions.getGender;
import static util.ForDataProvider.getMyData;

public class AddClientDataPrividerTest extends DoLogin  {

    @Test(dataProvider = "getData")
    public void addClientTest(String clientName, String clientSurname, String language,
                              String street1, String street2, String city, String state,
                              String zip, String country,
                              String phone, String fax, String mobile,
                              String email, String website,
                              String gender, String birthdate,
                              String vatId, String taxCode) throws SQLException, ClassNotFoundException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add(clientName);
        expected.add(clientSurname);
        expected.add(language.toLowerCase());
        expected.add(street1);
        expected.add(street2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(website);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(vatId);
        expected.add(taxCode);

        // Navigate to Add Client Page
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        // Create AddClientPage object
        AddClient addClient = new AddClient(driver);

        // Fill in Personal Information
        addClient.enterClientName(clientName);
        addClient.enterClientSurname(clientSurname);
        addClient.selectLanguage(language);

        // Fill in Address
        addClient.enterAddress(
                street1,
                street2,
                city,
                state,
                zip,
                country
        );

        // Fill in Birthdate & Gender
        addClient.enterBirthdate(birthdate);
        addClient.selectGender(gender);

        // Fill in Contact Information
        addClient.enterContactInfo(
                phone,
                fax,
                mobile,
                email,
                website
        );

        // Fill in Taxes Info
        addClient.enterTaxInfo(
                vatId,
                taxCode
        );

        // Save the form
        addClient.clickSave();

        // 1. loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. creating the connection
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/ip";
        Connection con = DriverManager.getConnection(url,username,password);

        // 3. creating statement
        Statement st = con.createStatement();

        // 4. execution of query
        String sql = "SELECT * FROM ip_clients where client_name='"+clientName+"'";
        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next()) {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String countryShort = rs.getString("client_country");

            actual.add(getCountry(countryShort));

            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(getGender(rs.getString("client_gender")));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected ="+expected);
        System.out.println("actual ="+actual);



        Assert.assertEquals(actual,expected,"This is not a dashboard");
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/AddClientFullData.xlsx","DB Testing");
    }
}
