package models

import play.api.db._
import play.api.Play.current
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._

case class Task(id: Long, label: String) extends KeyedEntity[Long] {
}

object Task {
  //SqueryL Code
  def all: List[Task] = inTransaction(from(AppDB.tasks) { s => select(s) }.toList)

  def create(label:String) {
    inTransaction {
      AppDB.tasks.insert(new Task(0,label))
    }
  }
  
  def delete(id: Long) {
    inTransaction {
      AppDB.tasks.delete(id)
    }
    
  }
}

object AppDB extends Schema {
  val tasks = table[Task]
}