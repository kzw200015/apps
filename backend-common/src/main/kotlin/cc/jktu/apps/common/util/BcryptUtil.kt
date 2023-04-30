package cc.jktu.apps.common.util

import org.mindrot.jbcrypt.BCrypt

object BcryptUtil {

    fun hashPassword(plain: String): String {
        return BCrypt.hashpw(plain, BCrypt.gensalt())
    }

    fun checkPassword(plain: String, hashed: String): Boolean {
        return BCrypt.checkpw(plain, hashed)
    }
}