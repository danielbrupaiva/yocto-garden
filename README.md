# YOCTO PROJECT PLAYGROUND

This repository intended to be a workspace for yocto project builds.

Host:
- Linux Debian 12 x86_64

Target:
- ARM64 BeaglePlay TI AM625 board

### Yocto Setup
According to the quick start guide from Yocto Project official page.

- Host enviroment setup

- Project Setup
  Workspace submodules:

- [Branches](https://wiki.yoctoproject.org/wiki/Releases)

  Scarthgap	5.0	April 2024	5.0 (April 2024)	Long Term Support (until April 2028)

### Submodules:

- poky
- meta-arm
- meta-ti
- meta-project


    $ BRANCH=scarthgap
    $ git submodule add -b ${BRANCH} git://git.yoctoproject.org/poky
    $ git submodule add -b ${BRANCH} git://git.yoctoproject.org/meta-arm
    $ git submodule add -b ${BRANCH} git://git.yoctoproject.org/meta-ti
    
    $ WORKDIR=$(pwd)
    $ BOARD=beagleplay
    $ BUILD_FOLDER=$WORKDIR/build_${BOARD}
    
    $ source $WORKDIR/poky/oe-init-build-env $BUILD_FOLDER


    (if need to create a new layer)
    $ bitbake-layers create-layer $HOME/yocto/meta-project
        - Edit meta-project according project needs

    $ bitbake-layers add-layer $WORKDIR/meta-arm/meta-arm \
                                $WORKDIR/meta-arm/meta-arm-toolchain/ \
                                $WORKDIR/meta-ti/meta-ti-bsp/ \
                                $WORKDIR/meta-ti/meta-ti-extras/ \
                                $WORKDIR/meta-project/
    
    $ echo 'MACHINE = "beagleplay"' >> $BUILD_FOLDER/conf/local.conf

    $ bitbake beagleplay-image-rt

### References
- https://wayland.pages.freedesktop.org/weston/toc/running-weston.html
- https://prashant-divate.medium.com/enable-weston-and-wayland-compositor-in-yocto-50a975cf1c1c
