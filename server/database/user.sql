-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************
--
CREATE USER inventory_app_owner
WITH PASSWORD 'inventory_app';

CREATE USER inventory_app_appuser
WITH PASSWORD 'inventory_app';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO inventory_app_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO inventory_app_owner;

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO inventory_app_appuser;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO inventory_app_appuser;
