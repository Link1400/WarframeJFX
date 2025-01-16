package CPT;

import java.util.ArrayList;

import javafx.scene.chart.PieChart;

public class weaponSort {

    private ArrayList<MeleeWeapon> originallist;

    public weaponSort(ArrayList<MeleeWeapon> originallist) {
        this.originallist = originallist;
    }

    public ArrayList<MeleeWeapon> insertionSort(ArrayList<MeleeWeapon> array, String field) {
        for (int i = 1; i < array.size(); i++) {
            MeleeWeapon weapon = array.get(i);
            Double property = getFieldValueSort(weapon, field);
            int selectedProperty = i - 1;

            while (selectedProperty >= 0 && getFieldValueSort(array.get(selectedProperty), field) > property) {
                array.set(selectedProperty + 1, array.get(selectedProperty));
                selectedProperty--;
            }
            array.set(selectedProperty + 1, weapon);
        }
        return array;
    }

    private Double getFieldValueSort(MeleeWeapon weapon, String field) {
        switch (field) {
            case "Impact":
                return weapon.getImpact();
            case "Puncture":
                return weapon.getPuncture();
            case "Slash":
                return weapon.getSlash();
            case "Base Damage":
                return weapon.getBaseDamage();
            case "Total Damage":
                return weapon.getTotalDamage();
            case "Critical Hit Chance":
                return weapon.getCritChance();
            case "Critical Hit Multiplier":
                return weapon.getCritMultiplier();
            case "Status Effect Chance":
                return weapon.getStatusChance();
            case "Attack Speed":
                return weapon.getSpeed();
            default:
                return null;
        }
    }

    public ArrayList<MeleeWeapon> insertionSortbyClass(ArrayList<MeleeWeapon> array) {
        for (int i = 1; i < array.size(); i++) {
            MeleeWeapon weapon = array.get(i);
            String classIN = weapon.getWeaponClass();
            int selectedProperty = i - 1;

            while (selectedProperty >= 0 && array.get(selectedProperty).getWeaponClass().compareTo(classIN) > 0) {
                array.set(selectedProperty + 1, array.get(selectedProperty));
                selectedProperty--;
            }
            array.set(selectedProperty + 1, weapon);
        }
        return array;
    }

    public PieChart countinstanceofClass(ArrayList<MeleeWeapon> array) {
        int AssaultSawCount = 0;
        int BladeandWhipCount = 0;
        int ClawCount = 0;
        int DaggerCount = 0;
        int DualDaggerCount = 0;
        int DualSwordCount = 0;
        int ExaltedCount = 0;
        int FistCount = 0;
        int GlaiveCount = 0;
        int GunBladeCount = 0;
        int HammerCount = 0;
        int HeavyBladeCount = 0;
        int MacheteCount = 0;
        int NikanaCount = 0;
        int NunchakuCount = 0;
        int PolearmCount = 0;
        int RapierCount = 0;
        int ScytheCount = 0;
        int SparringCount = 0;
        int StaffCount = 0;
        int SwordCount = 0;
        int SwordShieldCount = 0;
        int TonfaCount = 0;
        int twohNikanaCount = 0;
        int WarfanCount = 0;
        int WhipCount = 0;
        int ZawpartCount = 0;

        for (MeleeWeapon weapon : array) {
            if (weapon.getAttackName().equals("Normal Attack")) {
                switch (weapon.getWeaponClass()) {
                    case "Assault Saw":
                        AssaultSawCount++;
                        break;
                    case "Blade and Whip":
                        BladeandWhipCount++;
                        break;
                    case "Claws":
                        ClawCount++;
                        break;
                    case "Dagger":
                        DaggerCount++;
                        break;
                    case "Dual Daggers":
                        DualDaggerCount++;
                        break;
                    case "Dual Swords":
                        DualSwordCount++;
                        break;
                    case "Exalted Weapon":
                        ExaltedCount++;
                        break;
                    case "Fist":
                        FistCount++;
                        break;
                    case "Glaive":
                        GlaiveCount++;
                        break;
                    case "Gunblade":
                        GunBladeCount++;
                        break;
                    case "Hammer":
                        HammerCount++;
                        break;
                    case "Heavy Blade":
                        HeavyBladeCount++;
                        break;
                    case "Machete":
                        MacheteCount++;
                        break;
                    case "Nikana":
                        NikanaCount++;
                        break;
                    case "Nunchaku":
                        NunchakuCount++;
                        break;
                    case "Polearm":
                        PolearmCount++;
                        break;
                    case "Rapier":
                        RapierCount++;
                        break;
                    case "Scythe":
                        ScytheCount++;
                        break;
                    case "Sparring":
                        SparringCount++;
                        break;
                    case "Staff":
                        StaffCount++;
                        break;
                    case "Sword":
                        SwordCount++;
                        break;
                    case "Sword and Shield":
                        SwordShieldCount++;
                        break;
                    case "Tonfa":
                        TonfaCount++;
                        break;
                    case "Two-Handed Nikana":
                        twohNikanaCount++;
                        break;
                    case "Warfan":
                        WarfanCount++;
                        break;
                    case "Whip":
                        WhipCount++;
                        break;
                    case "Zaw":
                        ZawpartCount++;
                        break;
                    default:
                        break;
                
                }
            }
        }

                System.out.println(AssaultSawCount);
                System.out.println(BladeandWhipCount);
                System.out.println(ClawCount);
                System.out.println(DaggerCount);
                System.out.println(DualDaggerCount);
                System.out.println(DualSwordCount);
                System.out.println(ExaltedCount);
                System.out.println(FistCount);
                System.out.println(GlaiveCount);
                System.out.println(GunBladeCount);
                System.out.println(HammerCount);
                System.out.println(HeavyBladeCount);
                System.out.println(HammerCount);
                System.out.println(HeavyBladeCount);
                System.out.println(HammerCount);
                System.out.println(HeavyBladeCount);
                System.out.println(MacheteCount);
                System.out.println(NikanaCount);
                System.out.println(NunchakuCount);
                System.out.println(PolearmCount);
                System.out.println(RapierCount);
                System.out.println(ScytheCount);
                System.out.println(SparringCount);
                System.out.println(StaffCount);
                System.out.println(SwordCount);
                System.out.println(SwordShieldCount);
                System.out.println(TonfaCount);
                System.out.println(twohNikanaCount);
                System.out.println(WarfanCount);
                System.out.println(WhipCount);
                System.out.println(ZawpartCount);

                String[] labels = {
                        "Assault Saw", "Blade and Whip", "Claw", "Dagger", "Dual Dagger", "Dual Sword", "Exalted",
                        "Fist", "Glaive",
                        "Gun Blade", "Hammer", "Heavy Blade", "Machete", "Nikana", "Nunchaku", "Polearm", "Rapier",
                        "Scythe",
                        "Sparring", "Staff", "Sword", "Sword & Shield", "Tonfa", "Two-handed Nikana", "Warfan", "Whip",
                        "Zaw Part"
                };

                int[] counts = {
                        AssaultSawCount, BladeandWhipCount, ClawCount, DaggerCount, DualDaggerCount, DualSwordCount,
                        ExaltedCount, FistCount,
                        GlaiveCount, GunBladeCount, HammerCount, HeavyBladeCount, MacheteCount, NikanaCount,
                        NunchakuCount, PolearmCount,
                        RapierCount, ScytheCount, SparringCount, StaffCount, SwordCount, SwordShieldCount, TonfaCount,
                        twohNikanaCount,
                        WarfanCount, WhipCount, ZawpartCount
                };
                PieChart pieChart = new PieChart();
                for (int i = 0; i < labels.length; i++) {
                    if (counts[i] > 0) {
                        PieChart.Data slice = new PieChart.Data(labels[i], counts[i]);
                        pieChart.getData().add(slice);
                    }
                }

                pieChart.setLegendVisible(false);
                return pieChart;
            }
            
        }
    
