package gov.gsa.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.*;

/**
 * Created by michael.kellogg on 12/6/16.
 */
public class CommonUtils {
    /**
     * Process a {@code List} containing information about a field.
     * The field's label and data are split up and processing delegates to the appropriate {@code Consumer}.
     * <p>
     * Precondition: {@code List} contains field's label in first element and field's data in second element
     * Postcondition: {@code labelConsumer} is passed field's label and {@code dataConsumer} is passed field's data
     */
    public static void processField(List<String> fieldParse, Consumer<String> labelConsumer, Consumer<String> dataConsumer) {
        labelConsumer.accept(fieldParse.get(0));
        dataConsumer.accept(fieldParse.get(1));
    }

    /**
     * Convenience method to test that a field exists; see overloaded method for details
     */
    public static void testFieldAndDataExists(String fieldLabel, ArrayList<String> fieldParse) {
        testFieldAndDataExists(fieldLabel, fieldParse, true);
    }

    /**
     * Verifies either that a field that should exist does and has some data,
     * or that a field that shouldn't exist does not and has no data, based on the value of {@code shouldExist} param
     * <p>
     * Precondition: {@code List} contains field's label in first element and field's data in second element
     *
     * @param fieldLabel  The label that the field is expected to have (this should also be the field's name)
     * @param fieldParse  {@code List} containing information about a field
     * @param shouldExist {@code true} if the field is expected to exist, else {@code false}
     */
    public static void testFieldAndDataExists(String fieldLabel, List<String> fieldParse, boolean shouldExist) {
        String labelErrorMessage = fieldLabel + (shouldExist ? " label does not exist" : " label exists");
        String dataErrorMessage = fieldLabel + (shouldExist ? " data is empty" : " data is not empty");

        processField(
            fieldParse,
            label -> assertEquals(labelErrorMessage, label.contains(fieldLabel), shouldExist), // check label
            data -> assertEquals(dataErrorMessage, !data.isEmpty(), shouldExist) // check data
        );

        System.out.println(fieldLabel + (shouldExist ? " Label and Data exist" : " Label and Data do not exist"));
    }
}
