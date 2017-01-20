package gov.gsa.Tests;

import gov.gsa.Navigation.OpportunitiesObjectViewNavigation;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by RKumar on 1/13/2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpportunitiesPackagesTest extends Base{

    //Test Data - Notice Ids
    public String external_Link_package = "33274e2fa53eb34a24c4da02b0edfb26";//Test for external link
    public String single_package = "1954a3b14efff49e70c9ccf239e7e951";
    public String no_package = "165b3db50efea022a78c95872079cfd0";
    public String multiple_packages = "10460d4fd45a82cc5d85f0b7693138a0";
    public String secure_package = "5ffe4f3cb5e95af9071dc91d826ab0aa";


    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    @Test
    public void packageTitleTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(multiple_packages);
        assertEquals(OpportunitiesObjectViewPage.packagesTitle(), "Packages");
        System.out.println("Packages Section Title exists");
    }

    @Test
    public void downloadAllButtonTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(single_package);
        assertEquals(OpportunitiesObjectViewPage.downloadAllButton(), "Download All Packages");
        System.out.println("Download All Packages Button exists");
    }

    @Test
    public void downloadButtonTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(single_package);
        assertEquals(OpportunitiesObjectViewPage.downloadButton(), "Download");
        System.out.println("Packages Download Button exists");
    }

    @Test
    public void externalLinkTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(external_Link_package);
        assertEquals(OpportunitiesObjectViewPage.externalLink(), "See Solicitation");
        System.out.println("Packages - External Link exists");
    }

    @Test
    public void documentTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(single_package);
        ArrayList<String> pdf = OpportunitiesObjectViewPage.document();
        assertTrue("Document does not exists", pdf.get(0).length() > 1);
        assertTrue("Document Type is empty", pdf.get(1).length() > 1);
        System.out.println("Document exists within Package");
    }

    @Test
    public void documentIconTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(single_package);
        assertTrue("Document Icon does not exists", OpportunitiesObjectViewPage.documentIcon().contains("fa-file"));
        System.out.println("Packages Document Icon exists");
    }

    @Test
    public void noPackagesTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(no_package);

        assertTrue("No Package Message does not exists", OpportunitiesObjectViewPage.noPackage().equals("No packages uploaded."));
        System.out.println("No Packages Message exists");
    }


    @Test
    public void multiplePackagesCountTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(multiple_packages);
        int number = OpportunitiesObjectViewPage.multiplePackagesCount();
        System.out.println("Secured Packages Count " + number);
        assertTrue("Packages Count does not match", number > 1);
        System.out.println("Secured Packages Count matches");
    }

    @Test
    public void secureAndNotSecurePackagesCountTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(multiple_packages);
        ArrayList<Integer> count = OpportunitiesObjectViewPage.secureNotSecurePackagesCount();
        assertTrue("Secured Packages Count does not match", count.get(0) > 1);
        assertTrue("Not Secured Packages Count does not match", count.get(1) > 1);
        System.out.println("Secured and Not Secured Packages Count matches");
    }

    @Test
    public void securedContentTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(secure_package);
        ArrayList<String> content = OpportunitiesObjectViewPage.secureContent();
        assertTrue("Secured Type does not exists", content.get(0).contains("Secured"));
        assertTrue("Secured Content Message does not exists", content.get(1).contains("Secure/sensitive attachments are not currently available, please go to FBO.gov to view this attachment."));
        System.out.println("Secured Content exists");
    }

    @Test
    public void notSecuredTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(single_package);
        assertTrue("Secured Type does not exists", OpportunitiesObjectViewPage.notSecurePackage().equals("Not Secure"));
        System.out.println("Not Secured Content exists");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }
}

