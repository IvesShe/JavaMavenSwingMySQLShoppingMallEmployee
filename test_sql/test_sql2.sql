CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `shopping`.`view_shop_order_report` AS
    SELECT 
        `shopping`.`shop_order`.`shop_order_no` AS `shop_order_no`,
        `shopping`.`consumer`.`consumer_no` AS `consumer_no`,
        `shopping`.`consumer`.`consumer_name` AS `consumer_name`,
        `shopping`.`consumer`.`phone` AS `phone`,
        `shopping`.`consumer`.`address` AS `address`,
        `shopping`.`employee`.`name` AS `employee_name`,
        `shopping`.`product`.`product_name` AS `product_name`,
        `shopping`.`shop_order`.`amount` AS `amount`,
        (`shopping`.`shop_order`.`amount` * `shopping`.`product`.`price`) AS `total_sum`
    FROM
        (((`shopping`.`shop_order`
        JOIN `shopping`.`consumer` ON ((`shopping`.`shop_order`.`consumer_no` = `shopping`.`consumer`.`consumer_no`)))
        JOIN `shopping`.`employee` ON ((`shopping`.`shop_order`.`employee_no` = `shopping`.`employee`.`employee_no`)))
        JOIN `shopping`.`product` ON ((`shopping`.`shop_order`.`product_no` = `shopping`.`product`.`product_no`)))
    ORDER BY `shopping`.`shop_order`.`id`