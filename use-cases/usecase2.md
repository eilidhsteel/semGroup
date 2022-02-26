# USE CASE: 2  Produce a suite of Reports on cities in the world.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *World Health Organisation (WHO) analyst*, I want *to produce reports about cities, organised by population* so that *I can support the reporting of the organisation.*

### Scope

Organisation: WHO.

### Level

Primary task.

### Preconditions

* Database contains current city data.
* User provides N; where N is number of records required in top N reports.

### Success End Condition

The following reports are avaliable:
* All the cities in the world organised by largest population to smallest.
* All the cities in a continent organised by largest population to smallest.
* All the cities in a region organised by largest population to smallest.
* All the cities in a country organised by largest population to smallest.
* All the cities in a district organised by largest population to smallest.

* The top N populated cities in the world where N is provided by the user.
* The top N populated cities in a continent where N is provided by the user.
* The top N populated cities in a region where N is provided by the user.
* The top N populated cities in a country where N is provided by the user.
* The top N populated cities in a district where N is provided by the user.

### Failed End Condition

Any of the above reports are not produced.

### Primary Actor

WHO analyst.

### Trigger

WHO management requests the above reports for use in policy-making, and/or for release to the general public.

## MAIN SUCCESS SCENARIO

1. Management makes a request for information to Data Analysis team.
2. Analyst captures which reports are being requested and desired N; where N is number of records required in top N reports.
3. Analyst extracts requested report(s).
4. Analyst provides report(s) to management.

## EXTENSIONS

2. **There are less than N cities within scope of report requested**:
   1. Analyst extracts report with all avaliable cities and includes a note to inform management that there are less than N cities within the scope of the report.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0