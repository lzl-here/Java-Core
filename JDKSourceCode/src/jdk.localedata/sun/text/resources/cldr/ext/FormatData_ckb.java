/*
 * Copyright (c) 2012, 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * COPYRIGHT AND PERMISSION NOTICE
 *
 * Copyright (c) 1991-2020 Unicode, Inc. All rights reserved.
 * Distributed under the Terms of Use in https://www.unicode.org/copyright.html.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of the Unicode data files and any associated documentation
 * (the "Data Files") or Unicode software and any associated documentation
 * (the "Software") to deal in the Data Files or Software
 * without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, and/or sell copies of
 * the Data Files or Software, and to permit persons to whom the Data Files
 * or Software are furnished to do so, provided that either
 * (a) this copyright and permission notice appear with all copies
 * of the Data Files or Software, or
 * (b) this copyright and permission notice appear in associated
 * Documentation.
 *
 * THE DATA FILES AND SOFTWARE ARE PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT OF THIRD PARTY RIGHTS.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR HOLDERS INCLUDED IN THIS
 * NOTICE BE LIABLE FOR ANY CLAIM, OR ANY SPECIAL INDIRECT OR CONSEQUENTIAL
 * DAMAGES, OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE,
 * DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER
 * TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 * PERFORMANCE OF THE DATA FILES OR SOFTWARE.
 *
 * Except as contained in this notice, the name of a copyright holder
 * shall not be used in advertising or otherwise to promote the sale,
 * use or other dealings in these Data Files or Software without prior
 * written authorization of the copyright holder.
 */

package sun.text.resources.cldr.ext;

import java.util.ListResourceBundle;

public class FormatData_ckb extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "\u06a9\u0627\u0646\u0648\u0648\u0646\u06cc \u062f\u0648\u0648\u06d5\u0645",
               "\u0634\u0648\u0628\u0627\u062a",
               "\u0626\u0627\u0632\u0627\u0631",
               "\u0646\u06cc\u0633\u0627\u0646",
               "\u0626\u0627\u06cc\u0627\u0631",
               "\u062d\u0648\u0632\u06d5\u06cc\u0631\u0627\u0646",
               "\u062a\u06d5\u0645\u0648\u0648\u0632",
               "\u0626\u0627\u0628",
               "\u0626\u06d5\u06cc\u0644\u0648\u0648\u0644",
               "\u062a\u0634\u0631\u06cc\u0646\u06cc \u06cc\u06d5\u06a9\u06d5\u0645",
               "\u062a\u0634\u0631\u06cc\u0646\u06cc \u062f\u0648\u0648\u06d5\u0645",
               "\u06a9\u0627\u0646\u0648\u0646\u06cc \u06cc\u06d5\u06a9\u06d5\u0645",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "\u06a9",
               "\u0634",
               "\u0626",
               "\u0646",
               "\u0626",
               "\u062d",
               "\u062a",
               "\u0626",
               "\u0626",
               "\u062a",
               "\u062a",
               "\u06a9",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "\u06cc\u06d5\u06a9\u0634\u06d5\u0645\u0645\u06d5",
               "\u062f\u0648\u0648\u0634\u06d5\u0645\u0645\u06d5",
               "\u0633\u06ce\u0634\u06d5\u0645\u0645\u06d5",
               "\u0686\u0648\u0627\u0631\u0634\u06d5\u0645\u0645\u06d5",
               "\u067e\u06ce\u0646\u062c\u0634\u06d5\u0645\u0645\u06d5",
               "\u06be\u06d5\u06cc\u0646\u06cc",
               "\u0634\u06d5\u0645\u0645\u06d5",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "\u06cc",
               "\u062f",
               "\u0633",
               "\u0686",
               "\u067e",
               "\u06be",
               "\u0634",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "\u0686\u0627\u0631\u06d5\u06a9\u06cc \u06cc\u06d5\u06a9\u06d5\u0645",
               "\u0686\u0627\u0631\u06d5\u06a9\u06cc \u062f\u0648\u0648\u06d5\u0645",
               "\u0686\u0627\u0631\u06d5\u06a9\u06cc \u0633\u06ce\u06d5\u0645",
               "\u0686\u0627\u0631\u06d5\u06a9\u06cc \u0686\u0648\u0627\u0631\u06d5\u0645",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "\u0686\u0661",
               "\u0686\u0662",
               "\u0686\u0663",
               "\u0686\u0664",
            };
        final String[] metaValue_QuarterNarrows = new String[] {
               "\u0661",
               "\u0662",
               "\u0663",
               "\u0664",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "\u0628.\u0646",
               "\u062f.\u0646",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] metaValue_long_Eras = new String[] {
               "\u067e\u06ce\u0634 \u0632\u0627\u06cc\u06cc\u0646",
               "\u0632\u0627\u06cc\u06cc\u0646\u06cc",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a zzzz",
               "h:mm:ss a z",
               "h:mm:ss a",
               "h:mm a",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "G y MMMM d, EEEE",
               "d\u06cc MMMM\u06cc y G",
               "G y MMM d",
               "GGGGG y-MM-dd",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "GGGG y MMMM d, EEEE",
               "d\u06cc MMMM\u06cc y GGGG",
               "GGGG y MMM d",
               "G y-MM-dd",
            };
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayNames },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "arab.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0\u00a0%",
                    "",
                }
            },
            { "narrow.Eras", metaValue_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "DefaultNumberingSystem", "arab" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_long_Eras },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "roc.DayNames", metaValue_DayNames },
            { "standalone.DayAbbreviations", metaValue_DayNames },
            { "roc.MonthAbbreviations", metaValue_MonthNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "QuarterNarrows", metaValue_QuarterNarrows },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "standalone.QuarterNarrows", metaValue_QuarterNarrows },
            { "long.Eras", metaValue_long_Eras },
            { "roc.QuarterNarrows", metaValue_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "buddhist.MonthAbbreviations", metaValue_MonthNames },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} {0}",
                    "{1} {0}",
                    "{1} {0}",
                    "{1} {0}",
                }
            },
            { "narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "latn.NumberElements",
                new String[] {
                    ".",
                    ",",
                    ";",
                    "%",
                    "0",
                    "#",
                    "-",
                    "E",
                    "\u2030",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "japanese.MonthAbbreviations", metaValue_MonthNames },
            { "buddhist.DayNames", metaValue_DayNames },
            { "islamic.DayAbbreviations", metaValue_DayNames },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.QuarterNarrows", metaValue_QuarterNarrows },
            { "arab.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a",
                    "\u0660",
                    "#",
                    "\u200f-",
                    "\u0627\u0633",
                    "\u0609",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayNames },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "DayAbbreviations", metaValue_DayNames },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "DatePatterns",
                new String[] {
                    "y MMMM d, EEEE",
                    "d\u06cc MMMM\u06cc y",
                    "y MMM d",
                    "y-MM-dd",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayNames },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthNames },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1" },
            { "japanese.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "standalone.MonthAbbreviations", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "\u00a4\u00a0#,##0.00",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "buddhist.QuarterNarrows", metaValue_QuarterNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "roc.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
        };
        return data;
    }
}
