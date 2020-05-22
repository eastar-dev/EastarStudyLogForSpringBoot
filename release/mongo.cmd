> cls
> db
test
> use test
switched to db test
> show collections
studyItem
> db.studyItem.find().pretty()
{
        "_id" : ObjectId("5ec57448b1a16e0209472be0"),
        "nick" : "havve",
        "title" : "title1",
        "content" : "content1",
        "millisecond" : NumberLong("1589998664348"),
        "_class" : "dev.eastar.studylog.item.StudyItem"
}
....