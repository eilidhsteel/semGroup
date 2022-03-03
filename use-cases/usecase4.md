# USE CASE: 4 Produce a suite of reports on population statistics.
## CHARACTERISTIC INFORMATION

### Goal in Context

As a *World Health Organisation (WHO) analyst*, I want *to produce reports about the distribution of population around the world* so that *I can support the reporting of the organisation.*

### Scope

Organisation: WHO.

### Level

Primary task.

### Preconditions

* Database contains population city data.
* User provides the continent, region, country, or district to be reported on.

### Success End Condition

The following reports are avaliable:
* The population of people, people living in cities, and people not living in cities in each continent.
* The population of people, people living in cities, and people not living in cities in each region.
* The population of people, people living in cities, and people not living in cities in each country.

* The population of the world.
* The population of a continent.
* The population of a region.
* The population of a country.
* The population of a district.
* The population of a city.

Each report should contain the following fields:
* The name of the continent/region/country.
* The total population of the continent/region/country.
* The total population of the continent/region/country living in cities (including a %).
* The total population of the continent/region/country not living in cities (including a %).

### Failed End Condition

Any of the above reports are not produced.

### Primary Actor

WHO analyst.

### Trigger

WHO management requests the above reports for use in policy-making, and/or for release to the general public.

## MAIN SUCCESS SCENARIO

1. Management makes a request for information to Data Analysis team.
2. Analyst captures which reports are being requested and the continent, region, country, or district to be reported on.
3. Analyst extracts requested report(s).
4. Analyst provides report(s) to management.

## EXTENSIONS

2. **The continent, region, country, or district provided does not exist**:
   1. Analyst informs management that provided continent, region, country, or district does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
