require linux-intel.inc

KBRANCH = "4.14/yocto/base"
KMETA_BRANCH = "master"

# Fix for 32-bit perf issue. Remove when patch is backported to 4.14.
SRC_URI_append = " file://0001-perf-x86-32-explicitly-include-errno.h.patch"

DEPENDS += "elfutils-native openssl-native util-linux-native"

LINUX_VERSION ?= "4.14.15"
SRCREV_machine ?= "386c831d13803af8c6d73afa922333b4a796e994"
SRCREV_meta ?= "ee7e849882aa2f0947dd56a60ba5b0d2eec558f2"

# For Crystalforest and Romley
KERNEL_MODULE_AUTOLOAD_append_core2-32-intel-common = " uio"
KERNEL_MODULE_AUTOLOAD_append_corei7-64-intel-common = " uio"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"