$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ui/search.feature");
formatter.feature({
  "name": "Search Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate Search Functionality",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ui"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have browser opened",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchStepDef.i_have_browser_opened()"
});
formatter.write("Chrome Driver invoked and URL navigated as: https://www.bing.com/");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Search \"Infosys\" and Validate Search Result and click on Infosys url",
  "keyword": "When "
});
formatter.match({
  "location": "SearchStepDef.i_Search_and_Validate_Search_Result_and_click_on_Infosys_url(String)"
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("actual: Infosys - Bing , Expected: Infosys - Bing");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I move on next page and click on hamburger icon and select service link via mouse hover and click on Testing",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepDef.i_move_on_next_page_and_click_on_hamburger_icon_and_select_service_link_via_mouse_hover_and_click_on_Testing()"
});
formatter.write("actual: Infosys - Consulting | IT Services | Digital Transformation , Expected: Infosys - Consulting | IT Services | Digital Transformation");
formatter.write("actual: Quality Assurance (QA) Consulting Services | Infosys , Expected: Quality Assurance (QA) Consulting Services | Infosys");
formatter.result({
  "status": "passed"
});
formatter.write("Browser is Closed");
formatter.after({
  "status": "passed"
});
});