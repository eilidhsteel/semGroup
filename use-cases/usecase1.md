# USE CASE: As a world health organisation analyst, I want to produce reports by countries in the world about population so that I can support population reporting of the organisation

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *world health organisation* I want *to produce a reports on the countries in thw world, the continents of those countries and countries in a region organised by largest population to smallest. I want to produce reports on the countries in thw world, the continents of those countries and countries in a region based on the top N * so that *I can support population of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the role.  Database contains current population data.

### Success End Condition

A report is available for world health organisation to provide to population information.

### Failed End Condition

No report is produced.

### Primary Actor

World health organisation analyst.

### Trigger

A request for population information is sent to world health organisation.

## MAIN SUCCESS SCENARIO

1. World health organisation request countries information for a given roles.
2. World health organisation analyst captures name of the roles to get countries information.
3. World health extracts current population information of all countries of the given role.
4. World health organisation analyst provides reports to world health organisation.

## EXTENSIONS

3. **Role does not exist**:
    1. World health organisation analyst informs world health organisation no role exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0