Feature: Validating Rijksmuseum API

  @smoketest
  Scenario: Verify the count facets object in collection API for failure scenario
  When user call get method on "Collection" api
  Then check the countFacets object values in the response
    | hasimage | ondisplay |
    | 3407     | 28        |

  @smoketest
  Scenario: Verify the count facets object in collection API for successful scenario
  When user call get method on "Collection" api
  Then check the countFacets object values in the response
    | hasimage | ondisplay |
    | 3407     | 27        |
