$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/saucedemo/performance_automation.feature");
formatter.feature({
  "name": "SauceDemo performance automation",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sauceDemo_performance"
    }
  ]
});
formatter.scenario({
  "name": "HTTP requests",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sauceDemo_performance"
    }
  ]
});
formatter.step({
  "name": "User makes GET call in performance testing",
  "keyword": "Given "
});
formatter.match({
  "location": "Performance_stepdefs.user_makes_GET_call_in_performance_testing()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User makes POST call in performance testing",
  "keyword": "When "
});
formatter.match({
  "location": "Performance_stepdefs.user_makes_POST_call_in_performance_testing()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User makes PUT call in performance testing",
  "keyword": "Then "
});
formatter.match({
  "location": "Performance_stepdefs.user_makes_PUT_call_in_performance_testing()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User makes DELETE call in performance testing",
  "keyword": "And "
});
formatter.match({
  "location": "Performance_stepdefs.user_makes_DELETE_call_in_performance_testing()"
});
formatter.result({
  "status": "passed"
});
});