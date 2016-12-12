package gov.gsa.Utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by michael.kellogg on 12/8/16.
 */
public class GraphObject {

        int graphsize;
        List<WebElement> xaxis;

        public List<WebElement> getXaxis() {
            return xaxis;
        }

        public int getGraphsize() {
            return graphsize;
        }

        public void setXaxis(List<WebElement> xaxis) {
            this.xaxis = xaxis;
        }

        public void setGraphsize(int graphsize) {
            this.graphsize = graphsize;
        }
}
