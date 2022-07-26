..
 # Copyright (c) 2022, Arm Limited.
 #
 # SPDX-License-Identifier: MIT

#############
User Accounts
#############

EWAOL distribution images contain the following user accounts:

 * ``root`` with administrative privileges enabled by default. The login is
   disabled if ``ewaol-security`` is included in ``DISTRO_FEATURES``.
 * ``ewaol`` with administrative privileges enabled with ``sudo``.
 * ``user``  without administrative privileges.
 * ``test`` with administrative privileges enabled with ``sudo``. This account
   is created only if ``ewaol-test`` is included in ``DISTRO_FEATURES``.

By default, each users account has disabled password. The default
administrative group name is ``sudo``. Other sudoers configuration is included
in ``meta-ewaol-distro/recipes-extended/sudo/files/ewaol_admin_group.in``.
For virtualization images, above user accounts are created for Control VM and
Guest VM domains.

If ``ewaol-security`` is included in ``DISTRO_FEATURES``, each user is prompted
to a set new password on first login. For more information about security see:
:ref:`Security Hardening<manual/hardening:Security Hardening>`.

All :ref:`validation_run-time_integration_tests` are executed as the ``test``
user.

An EWAOL distribution image can be configured to include run-time integration
tests that validate successful configuration of the EWAOL user accounts. Details
of the user accounts validation tests can be found in the
:ref:`manual_validation_user_accounts_tests` section of the
:ref:`Validation<manual/validation:Validation>` documentation.
