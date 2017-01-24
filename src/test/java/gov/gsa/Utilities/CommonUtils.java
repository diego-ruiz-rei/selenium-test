package gov.gsa.Utilities;

import java.util.function.Predicate;

import static jdk.nashorn.internal.objects.NativeRegExp.test;
import static org.junit.Assert.*;

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

    public static void testLabelExists(DataField field, boolean shouldExist) {
        assertLabelExists(field, shouldExist);
        System.out.println(field.name + (shouldExist ? " label exists" : " label does not exist"));
    }

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

    public static void testDataContains(DataField field, String expectedData) {
        assertTrue(field.name + " does not have expected data", field.data.contains(expectedData));
    }
}