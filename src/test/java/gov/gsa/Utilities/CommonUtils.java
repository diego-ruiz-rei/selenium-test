package gov.gsa.Utilities;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.SearchPage;
import org.openqa.selenium.By;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Created by michael.kellogg on 12/6/16.
 */
public class CommonUtils {
    /**
     * Model a simple field that consists of just a label and data, and has a name
     */
    public static class DataField {
        public String name;
        public String label;
        public String data;

        public DataField(String name, String label, String data) {
            this.name = name;
            this.label = label;
            this.data = data;
        }

        public DataField setName(String name) {
            this.name = name;
            return this;
        }

        public DataField setLabel(String label) {
            this.label = label;
            return this;
        }

        public DataField setData(String data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Convenience methods to test that parts of a field exists; see overloaded methods for details
     */
    public static void testLabelAndDataExists(DataField field) { testLabelAndDataExists(field, true); }
    public static void testLabelExists(DataField field) { testLabelExists(field, true); }
    public static void testDataExists(DataField field) { testDataExists(field, true); }

    /**
     * Verifies either that a field that should exist does and has some data,
     * or that a field that shouldn't exist does not and has no data, based on the value of {@code shouldExist} param
     * <p>
     * Precondition: {@code field} and its elements are not {@code null}
     *
     * @param field A {@code Field} object that has been populated with information on the field
     * @param shouldExist {@code true} to check that the field exists, else {@code false}
     */
    public static void testLabelAndDataExists(DataField field, boolean shouldExist) {
        assertLabelExists(field, shouldExist);
        assertDataExists(field, shouldExist);

        System.out.println(field.name + (shouldExist ? " label and data exists" : " label and data does not exist"));
    }

    /**
     * Verifies either that a field's label exists or does not exist, based on the value of {@code shouldExist} param
     * <p>
     * Precondition: {@code field.label} is not {@code null}
     *
     * @param field A {@code Field} object that has been populated with information on the field
     * @param shouldExist {@code true} to check that the label exists, else {@code false}
     */
    public static void testLabelExists(DataField field, boolean shouldExist) {
        assertLabelExists(field, shouldExist);
        System.out.println(field.name + (shouldExist ? " label exists" : " label does not exist"));
    }

    /**
     * Verifies either that a field's data exists or does not exist, based on the value of {@code shouldExist} param
     * <p>
     * Precondition: {@code field.data} is not {@code null}
     *
     * @param field A {@code Field} object that has been populated with information on the field
     * @param shouldExist {@code true} to check that the data exists, else {@code false}
     */
    public static void testDataExists(DataField field, boolean shouldExist) {
        assertDataExists(field, shouldExist);
        System.out.println(field.name + (shouldExist ? " data exists" : " data does not exist"));
    }

    private static void assertLabelExists(DataField field, boolean shouldExist) {
        String labelErrorMessage = field.name + (shouldExist ? " label does not exist" : " label exists");
        assertTrue(labelErrorMessage, field.label.isEmpty() != shouldExist);
    }

    private static void assertDataExists(DataField field, boolean shouldExist) {
        String dataErrorMessage = field.name + (shouldExist ? " data is empty" : " data is not empty");
        assertTrue(dataErrorMessage, field.data.isEmpty() != shouldExist);
    }

    public static void testLabelContains(DataField field, String expectedLabel) {
        assertTrue(field.name + " does not have expected label", field.label.contains(expectedLabel));
    }

    public static void testContainsLabel(DataField field, String expectedLabel) {
        assertTrue(field.name + " does not have expected label", expectedLabel.contains(field.label));
    }

    public static void testDataContains(DataField field, String expectedData) {
        System.out.println("tested if " + field.data + " was the same as " + expectedData);
        assertTrue(field.name + " does not have expected data", field.data.contains(expectedData));
    }

    // test autocomplete generic function - checks if first item in autocomplete matches string provided as a parameter
    // example of how to implement -> assertTrue(CommonUtils.autoCompleteExists("AR20160001"));
    public static boolean autoCompleteExists(String index,String searchText) throws InterruptedException {
        // takes actions to open auto-complete window
        SearchNavigation.gotoAutoComplete(index,searchText);
        // this just returns a bool value of if autocomplete window shows up or not
        return autoCompleteSearchMatch(searchText);
    }

    // test autocomplete helper function
    public static boolean autoCompleteSearchMatch(String searchText){

        String firstAutoCompleteItem = SearchPage.autoCompleteFirstItem();
        System.out.println("expected data: " + searchText + " captured data: " + firstAutoCompleteItem);

        if(firstAutoCompleteItem.equalsIgnoreCase(searchText)){
            return true;
        }
        return false;
    }

    //spilt label and data
    public static DataField splitLabelAndData(String element) {
        String fieldLabel = element.substring(0, element.indexOf(':')).trim(); // get all up to but not including colon
        String fieldData = element.substring(element.indexOf(':') + 1).trim(); // get all after and not including colon
        System.out.println("Field Label : "+fieldLabel+"\nField Data : "+fieldData);

        return new DataField(null, fieldLabel, fieldData);
    }

    //parse string and format to Date format
    public static String formatDate(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date date = simpleDateFormat.parse(dateString);

        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Formatted Date : " + simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }

    //check for total results message
    public static long extractTotalResults() throws ParseException {
        String resultText=Base.driver.findElement(By.cssSelector(".usa-width-three-fourths > .usa-width-one > strong")).getText();

        String[] splitMessage = resultText.split("\\s+");

        long totalCount = (long) NumberFormat.getNumberInstance(java.util.Locale.US).parse(splitMessage[5]);
        System.out.print(totalCount);

        return totalCount;

    }

}