/*This sql trigger will automatically update all of the user_id's to be in proper order, once a user is deleted*/

DELIMITER //

CREATE TRIGGER update_user_id_after_delete
    AFTER DELETE ON users
    FOR EACH ROW
BEGIN
    DECLARE max_id INT; /*creating a temporary variable to hold the highest user_id*/
    SET max_id = (SELECT MAX(user_id) FROM users); /*setting max_id to equal the highest current user_id*/

    IF max_id IS NOT NULL THEN
    UPDATE users
    SET user_id = user_id - 1
    WHERE user_id > OLD.user_id; /*OLD gets the old value of the column before the update*/
END IF;
END;
//

DELIMITER ;
