/* NSC -- new Scala compiler
 * Copyright 2005-2010 LAMP/EPFL
 * @author Paul Phillips
 */

package scala.tools.nsc

package object interpreter {
  /** Apply a function and return the passed value */
  def returning[T](x: T)(f: T => Unit): T = { f(x) ; x }

  /** Tracing */
  def tracing[T](msg: String)(x: T): T = { println("(" + msg + ") " + x) ; x }

  /** Frequency counter */
  def freq[T](seq: Seq[T]) = seq groupBy identity mapValues (_.length)

  /** null becomes "", otherwise identity */
  def onull(s: String) = if (s == null) "" else s

  /** Class objects */
  def classForName(name: String): Option[Class[_]] =
    try Some(Class forName name)
    catch { case _: ClassNotFoundException | _: SecurityException => None }
}
