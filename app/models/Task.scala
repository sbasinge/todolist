package models

//import anorm._
//import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._

case class Task(id: Long, label: String) extends KeyedEntity[Long] {
}

object Task {
  // Anorm Code
  //	val task = {
  //		get[Long]("id") ~
  //		get[String]("label") map {
  //			case id~label => Task(id, label)
  //		}
  //	}
  //	
  //	def all(): List[Task] = DB.withConnection { implicit c =>
  //		SQL("select * from task").as(task *)
  //	}
  //
  //	
  //	def create(label:String) {
  //		DB.withConnection { implicit c =>
  //			SQL("insert into task (label) values ({label})").on(
  //				'label -> label
  //			).executeUpdate()
  //		}
  //	}
  //	
  //	def delete(id: Long) {
  //		DB.withConnection { implicit c =>
  //			SQL("delete from task where id = {id}").on(
  //				'id -> id
  //			).executeUpdate()
  //		}
  //	}

  //SqueryL Code
    //	val task = {
  //		get[Long]("id") ~
  //		get[String]("label") map {
  //			case id~label => Task(id, label)
  //		}
  //	}

  
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