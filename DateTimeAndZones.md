Because dates, times and time zones are so much fun...

# Dates, times and time zones in Java


[**ZoneOffset**](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html) = A time-zone offset from Greenwich/UTC. For example, +02:00.


A [**ZoneId**](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html) is used to identify the rules used to convert between an [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html) and a [LocalDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html). 
There are two distinct types of ID:

* Fixed offsets - a fully resolved offset from UTC/Greenwich, that uses the same offset for all local date-times
* Geographical regions - an area where a specific set of rules for finding the offset from UTC/Greenwich apply

