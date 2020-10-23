Because dates, times and time zones are so much fun...

# Dates, times and time zones in Java

Central European Time (CET) is UTC +1.
Central European Summer Time (CEST) is UTC +2.

[**ZoneOffset**](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html) = A time-zone offset from Greenwich/UTC. For example, +02:00.

A [**ZoneId**](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html) is used to identify the rules used to convert between an [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html) and a [LocalDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html).

LocalDateTime.atOffset(ZoneOffset offset) - Combines this date-time with an offset to create an OffsetDateTime.

[OffsetDateTime.withOffsetSameInstant(ZoneOffset offset)](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html#withOffsetSameInstant-java.time.ZoneOffset-) - Returns a copy of this OffsetDateTime with the specified offset ensuring that the result is at the same instant.

This method returns an object with the specified ZoneOffset and a LocalDateTime adjusted by the difference between the two offsets. This will result in the old and new objects representing the same instant. This is useful for finding the local time in a different offset. For example, if this time represents 2007-12-03T10:30+02:00 and the offset specified is +03:00, then this method will return 2007-12-03T11:30+03:00.


## Here is how you can get ZoneOffset from ZoneId:

Instant instant = Instant.now(); //can be LocalDateTime
ZoneId systemZone = ZoneId.systemDefault(); // my timezone
ZoneOffset currentOffsetForMyZone = systemZone.getRules().getOffset(instant);
NB: ZoneId can have different offset depending on point in time and the history of the particular place. So choosing different Instants would result in different offsets.

NB2: ZoneId.of() can return a ZoneOffset instead of ZoneId if UTC+3/GMT+2/etc is passed as opposed to a time zone like Africa/Cairo. So if UTC/GMT offsets are passed then historical/geographical/daylight-saving information of the Instant won't be taken into account - you'll simply work with the specified offset.

https://stackoverflow.com/questions/32626733/is-there-any-way-to-convert-zoneid-to-zoneoffset-in-java-8







