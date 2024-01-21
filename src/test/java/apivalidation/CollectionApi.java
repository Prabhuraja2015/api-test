package apivalidation;

import com.pojo.collection.CollectionResponse;
import utils.Reusable;

import static org.junit.Assert.assertEquals;

/*All Collection API validations in this class */
public class CollectionApi extends Reusable {

    /* CountFaces object validation in collection API  */
    public void verifyCountFacets(CollectionResponse response, int hashImgExpected, int ondispExpected){
        try {
            assertEquals(hashImgExpected, response.getCountFacets().getHasimage());
            assertEquals(ondispExpected, response.getCountFacets().getOndisplay());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    }



