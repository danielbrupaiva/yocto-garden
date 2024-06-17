SUMMARY = "BeaglePlay RT Core Image "
DESCRIPTION = "bitbake-layers recipe for BeaglePlay projects with PREEMPT-RT patch"
LICENSE = "MIT"

MACHINE ?= "beagleplay"

# PREEMPT-RT patch
PREFERRED_PROVIDER_virtual/kernel_beagleplay = "linux-ti-staging-rt-6.6"
# PREFERRED_PROVIDER_virtual/kernel_beagleplay = "linux-yocto-rt"
COMPATIBLE_MACHINE_beagleplay = "beagleplay"

# Distro Features
DISTRO_FEATURES += "systemd"
DISTRO_FEATURES += "keyboard"
DISTRO_FEATURES += "wifi"
DISTRO_FEATURES += "usrmerge" 
#DISTRO_FEATURES += "usbhost"
DISTRO_FEATURES += "opengl"
DISTRO_FEATURES += "directfb"
#DISTRO_FEATURES += "x11"
DISTRO_FEATURES += "wayland"

# Image features configuration
# https://docs.yoctoproject.org/4.0.18/ref-manual/features.html

IMAGE_FEATURES += "package-management"
IMAGE_FEATURES += "empty-root-password"
IMAGE_FEATURES += "allow-empty-password"
#IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FEATURES += "ssh-server-dropbear"
IMAGE_FEATURES += "splash"
IMAGE_FEATURES += "hwcodecs"
IMAGE_FEATURES += "weston"
#
IMAGE_INSTALL += "weston"
IMAGE_INSTALL += "weston-init"
IMAGE_INSTALL += "wayland"
IMAGE_INSTALL += "wayland-protocols"

# DEV image configuration
IMAGE_FEATURES += "dev-pkgs"
IMAGE_FEATURES += "tools-sdk"
IMAGE_FEATURES += "tools-debug"
IMAGE_FEATURES += "eclipse-debug"
IMAGE_FEATURES += "tools-profile"
IMAGE_FEATURES += "tools-testapps"
IMAGE_FEATURES += "debug-tweaks"
#
IMAGE_INSTALL += "kernel-devsrc"
IMAGE_INSTALL += "kernel-modules"
IMAGE_INSTALL += "kernel-devicetree"
#IMAGE_INSTALL += "rt-tests"
IMAGE_INSTALL += "hwlatdetect"
#
IMAGE_INSTALL += "bash"
IMAGE_INSTALL += "sudo"
IMAGE_INSTALL += "net-tools"
# Additional image features
USER_CLASSES ?= "buildstats"

inherit core-image